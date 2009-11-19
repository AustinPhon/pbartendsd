/**
 * Date: Nov 14, 2009
 * Project: XMLParsingDemo
 * User: dmason
 * This software is subject to license of
 * IBBL-TGen
 * http://www.gouvernement.lu/
 * http://www.tgen.org 
 */
package com.card.domain;

/**
 * @author dmason
 * @version $Revision$ $Date$ $Author$ $Id$
 */
public class FlashCard {
	
	public String question;
	public String answer;
	public int cardNum;
	public boolean isCorrect=true; //assumes is correct by default
	public boolean wasSeen=false; //assuses not seen by default

	public FlashCard(String q,String a,int num){
		this.question =q;
		this.answer=a;
		this.cardNum=num;
	}
	
}
