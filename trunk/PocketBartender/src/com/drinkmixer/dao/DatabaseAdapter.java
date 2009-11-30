package com.drinkmixer.dao;


public class DatabaseAdapter {//extends SQLiteOpenHelper {
/*
	public static SQLiteDatabase sqliteDb=null;
	private static DatabaseAdapter instance; //for singleton
	
	private static final String DATABASE_NAME = "pBartender7";
	private static final int DATABASE_VERSION = 1;
	
	public DatabaseAdapter(Context context, String name, CursorFactory factory,int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//create drink category table
		db.execSQL(DataDAO.sqlCreateDrinkCategoriesTable);
		
		//create drinks table
		db.execSQL(DataDAO.sqlCreateDrinksTable);
		
		//create ingredients table
		db.execSQL(DataDAO.sqlCreateIngTable);
		
		//create ingredients table
		db.execSQL(DataDAO.sqlDrinkIngredientsTable);
		
		//create drink sub cat table
		//db.execSQL(DataDAO.sqlDrinkSubCategoriesTable);
		
		//create fractional amount table
		db.execSQL(DataDAO.sqlFractional_amountsTable);
		
		//create glasses table
		db.execSQL(DataDAO.sqlGlassesTable);
		
		//create ingredients cat table
		db.execSQL(DataDAO.sqlIngredientsCatTable);
		
		//create ingredients sub cat
		db.execSQL(DataDAO.sqlIngredientsSubCatTable);
		
		//fill drink cat table
		fillDrinkCategories(db);
		
		//fill ingredient cat table
		fillIngredientsCategories(db);
		
		//fills drinks sub cat table
		//fillDrinkSubCategories(db);
		
		//fill drink ingredients table
		fillDrinkIngredients(db);
		
		//fill drinks table
		DrinkInserts di = new DrinkInserts();
		for(int i=0;i<di.sqlInsertDrinks.length;i++)
			db.execSQL(di.sqlInsertDrinks[i]);
		
		//fill ingredients table
		IngredientsInsert ii = new IngredientsInsert();
		for(int i=0;i<ii.sqlInsertIngredients.length;i++)
			db.execSQL(ii.sqlInsertIngredients[i]);
		
		//fill ingredients sub cats table
		IngredientsSubCatInsert isci = new IngredientsSubCatInsert();
		for(int i=0;i<isci.sqlInsertIngredientsSubCat.length;i++)
			db.execSQL(isci.sqlInsertIngredientsSubCat[i]);
		
		//fill glasses table		
		for(int i=0;i<GlassesInsert.sqlInsertGlasses.length;i++)
			db.execSQL(GlassesInsert.sqlInsertGlasses[i]);
		
		//fill fractions table		
		for(int i=0;i<GlassesInsert.sqlInsertFractions.length;i++)
			db.execSQL(GlassesInsert.sqlInsertFractions[i]);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		  Log.w(getClass().getSimpleName(), "Upgrading database from version " + oldVersion + " to "
	                + newVersion + ", which will destroy all old data");
		  
		  dropTables(db);
	      onCreate(db);
	}
	
	/**
	 * Drops all the tables
	 * @param db
	 *
	private void dropTables(SQLiteDatabase db)
	{
		 db.execSQL("DROP TABLE IF EXISTS " + DataDAO.TABLE_DRINK );
		 db.execSQL("DROP TABLE IF EXISTS " + DataDAO.TABLE_DRINK_CAT );
		 db.execSQL("DROP TABLE IF EXISTS " + DataDAO.TABLE_DRINK_INGREDIENTS );
		// db.execSQL("DROP TABLE IF EXISTS " + DataDAO.TABLE_DRINK_SUB_CAT );
		 db.execSQL("DROP TABLE IF EXISTS " + DataDAO.TABLE_FRACTIONAL_AMOUNTS );
		 db.execSQL("DROP TABLE IF EXISTS " + DataDAO.TABLE_GLASSES );
		 db.execSQL("DROP TABLE IF EXISTS " + DataDAO.TABLE_INGREDIENTS );
		 db.execSQL("DROP TABLE IF EXISTS " + DataDAO.TABLE_INGREDIENTS_CAT );
		 db.execSQL("DROP TABLE IF EXISTS " + DataDAO.TABLE_INGREDIENTS_SUB_CAT );
		 
	}

	
	private void fillIngredientsCategories(SQLiteDatabase db) {
		
		
		String[] sqlInsertIngredientCat ={"INSERT INTO "+DataDAO.TABLE_INGREDIENTS_CAT+" VALUES(1,'Liquor');"
		,"INSERT INTO "+DataDAO.TABLE_INGREDIENTS_CAT+" VALUES(2,'Mixers');"
		,"INSERT INTO "+DataDAO.TABLE_INGREDIENTS_CAT+" VALUES(3,'Garnish');"};
		 
		for(int i=0;i<sqlInsertIngredientCat.length;i++)
			db.execSQL(sqlInsertIngredientCat[i]);
	}


	/**
	 * creates the drink types in the database
	 * @param db
	 *
	private void fillDrinkCategories(SQLiteDatabase db) {
		
		String[] types = { "","Cocktails", "Hot Drinks", "Jello Shots", "Martinis",
				"Non-Alcoholic", "Punches", "Shooters"};
		Arrays.sort(types);

		ContentValues values;
		
		//start from 1 so the array has a blank
		for(int i=1;i<types.length;i++)
		{
			values = new ContentValues();
			values.put(DataDAO.COL_NAME, types[i]); 
			values.put(DataDAO.COL_ROW_ID, i); 
			db.insert(DataDAO.TABLE_DRINK_CAT, null, values);
		}
		 
	}

	private void fillDrinkIngredients(SQLiteDatabase db)
	{
		String[] dii1 = DrinkIngredientsInsert.insertDrinkIng1();
		for(int i=0;i<dii1.length;i++)
			db.execSQL(dii1[i]);
		
		String[] dii2 = DrinkIngredientsInsert.insertDrinkIng2();
		for(int i=0;i<dii2.length;i++)
			db.execSQL(dii2[i]);
		
		String[] dii3 = DrinkIngredientsInsert.insertDrinkIng3();
		for(int i=0;i<dii3.length;i++)
			db.execSQL(dii3[i]);
		
		String[] dii4 = DrinkIngredientsInsert.insertDrinkIng4();
		for(int i=0;i<dii4.length;i++)
			db.execSQL(dii4[i]);
		
		String[] dii5 = DrinkIngredientsInsert.insertDrinkIng5();
		for(int i=0;i<dii5.length;i++)
			db.execSQL(dii5[i]);
		
		String[] dii6 = DrinkIngredientsInsert.insertDrinkIng6();
		for(int i=0;i<dii6.length;i++)
			db.execSQL(dii6[i]);
	}
	
	//singleton initialize
	private static void initialize(Context context) {
		if(instance == null) {
			instance = new DatabaseAdapter(context, DATABASE_NAME, null, DATABASE_VERSION);
			sqliteDb = instance.getWritableDatabase();
		}
	}
	
	/**
	 * Pubic method to instantiate class
	 * @param context
	 * @return
	 *
	public static final DatabaseAdapter getInstance(Context context) {
		initialize(context);
		return instance;
	}
	
	/**
	 * gets the database we are using
	 * @return
	 *
	public SQLiteDatabase getDatabase() {
		return sqliteDb;	
	}
	
	/**
	 * closes instance of database
	 *
	public void close() {
		if(instance != null ) { 
			instance.close();
			instance = null;
		}
	}
*/
}
