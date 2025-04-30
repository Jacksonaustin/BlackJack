package main;
import java.awt.*;
import java.awt.*; 
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class JackBlack {
	
	ArrayList<Card> deck;
	
	public JackBlack() {
		
		startGame(); 
		
	}
	
	public void startGame() {
		
		buildDeck();
		
	}
	
	public void buildDeck() {
		deck = new ArrayList<Card>();
	}

}
