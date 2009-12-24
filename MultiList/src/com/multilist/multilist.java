package com.multilist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class multilist extends Activity {
	
	 ListView countryList;  
     ListView stateList; 
     ListView glassList;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_list);
        
        glassList = (ListView)findViewById(R.id.listGlasses);
        
        //addes images to list items
        List<Drawable> imageList = new ArrayList<Drawable>(); 
        
        imageList.add(getResources().getDrawable(R.drawable.champ));
        imageList.add(getResources().getDrawable(R.drawable.cocktail));
        imageList.add(getResources().getDrawable(R.drawable.highball));
        imageList.add(getResources().getDrawable(R.drawable.hurricane));
        imageList.add(getResources().getDrawable(R.drawable.irish));
        imageList.add(getResources().getDrawable(R.drawable.margarita));
        imageList.add(getResources().getDrawable(R.drawable.mug));
        imageList.add(getResources().getDrawable(R.drawable.parfait));
        imageList.add(getResources().getDrawable(R.drawable.hurricane));

        
        glassList.setAdapter(new ImageListAdapter(this,imageList,glassList));
        
        
/*
        countryList = (ListView) findViewById(R.id.listCountry);
        
        //addes images to list items
        List<ImageAndText> l = new ArrayList<ImageAndText>(); 
        
        ImageAndText  iat = new ImageAndText("http://www.rcgawker.com/wp-content/uploads/2009/10/tamiya-sand-scorcher_sm.jpg","My icon");
        l.add(iat);
          iat = new ImageAndText("http://www.rcgawker.com/wp-content/uploads/2009/10/tamiya-sand-scorcher_sm.jpg","My icon");
        l.add(iat);
          iat = new ImageAndText("http://www.rcgawker.com/wp-content/uploads/2009/09/venom.jpg","My icon");
        l.add(iat);
          iat = new ImageAndText("http://www.rcgawker.com/wp-content/uploads/2009/10/tamiya-sand-scorcher_sm.jpg","My icon");
        l.add(iat);
          iat = new ImageAndText("http://www.rcgawker.com/wp-content/uploads/2009/10/tamiya-sand-scorcher_sm.jpg","My icon");
        l.add(iat);
          iat = new ImageAndText("http://www.rcgawker.com/wp-content/uploads/2009/10/tamiya-sand-scorcher_sm.jpg","My icon");
        l.add(iat);
          iat = new ImageAndText("http://www.rcgawker.com/wp-content/uploads/2009/10/tamiya-sand-scorcher_sm.jpg","My icon");
        l.add(iat);
          iat = new ImageAndText("http://www.rcgawker.com/wp-content/uploads/2009/10/tamiya-sand-scorcher_sm.jpg","My icon");
        l.add(iat);
          iat = new ImageAndText("http://www.rcgawker.com/wp-content/uploads/2009/10/tamiya-sand-scorcher_sm.jpg","My icon");
        l.add(iat);
          iat = new ImageAndText("http://www.rcgawker.com/wp-content/uploads/2009/10/tamiya-sand-scorcher_sm.jpg","My icon");
        l.add(iat);
        
        
        countryList.setAdapter(new ImageAndTextListAdapter(this,l,countryList));
        
        //******** creates a 2 coloum list view
        countryList = (ListView) findViewById(R.id.listCountry); 
        stateList = (ListView) findViewById(R.id.listStates); 
        
        countryList.setAdapter(new ArrayAdapter<String>(this,
        		R.layout.rowlayout, COUNTRIES));

        stateList.setAdapter(new ArrayAdapter<String>(this,
        		R.layout.rowlayout, STATES));
        */		
        		
    }
    
    
    
    static final String[] STATES = new String[] {"AZ","CA","MO","UT","FL","NY","OH","AR"};
    
    static final String[] COUNTRIES = new String[] {
        "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
        "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
        "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
        "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
        "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
        "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
        "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
        "Cote d'Ivoire", "Cambodia", "Cameroon", "Canada", "Cape Verde",
        "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
        "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
        "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic",
        "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
        "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
        "Estonia", "Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji", "Finland",
        "Former Yugoslav Republic of Macedonia", "France", "French Guiana", "French Polynesia",
        "French Southern Territories", "Gabon", "Georgia", "Germany", "Ghana", "Gibraltar",
        "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau",
        "Guyana", "Haiti", "Heard Island and McDonald Islands", "Honduras", "Hong Kong", "Hungary",
        "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
        "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
        "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
        "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
        "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova",
        "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
        "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand",
        "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Marianas",
        "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru",
        "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
        "Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe", "Saint Helena",
        "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon",
        "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Saudi Arabia", "Senegal",
        "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
        "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "South Korea",
        "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen", "Swaziland", "Sweden",
        "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "The Bahamas",
        "The Gambia", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey",
        "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda",
        "Ukraine", "United Arab Emirates", "United Kingdom",
        "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
        "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Wallis and Futuna", "Western Sahara",
        "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"
      };

}