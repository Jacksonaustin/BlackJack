package main;
import java.awt.*;
import java.awt.*; 
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;


public class JackBlack {
	
	ArrayList<Card> deck;
	Random rng = new Random();
	Card hiddenCard;
	ArrayList<Card> dealerHand;
	int dealerSum;
	int dealerAceCount;
	
	ArrayList<Card> playerHand;
	int playerSum;
	int playerAceCount;
	
	int boardWidth = 600;
	int boardHeight = boardWidth;
	
	int cardWidth = 110;
	int cardHeight = 154;
	
	JFrame frame = new JFrame("UAFS UNDERGROUND CASINO");
	JPanel gamePanel = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			try {
			Image hiddenCardImg = new ImageIcon(getClass().getResource("/cards/BACK.png")).getImage();
			g.drawImage(hiddenCardImg, 20, 20 , cardWidth, cardHeight, null);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	};
	JPanel buttonPanel = new JPanel();
	JButton hitButton = new JButton("Hit");
	JButton stayButton = new JButton("Stay");
	
	public JackBlack() {
		
		startGame(); 
		
		frame.setVisible(true);		
		frame.setSize(boardWidth, boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gamePanel.setLayout(new BorderLayout());
		gamePanel.setBackground(new Color(53,101,77));
		frame.add(gamePanel);
		
		hitButton.setFocusable(false);
		buttonPanel.add(hitButton);
		buttonPanel.add(stayButton);
		frame.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void startGame() {
		
		buildDeck();
		shuffleDeck();
		
		dealerHand = new ArrayList<Card>();
		dealerSum=0;
		dealerAceCount=0;
		
		hiddenCard = deck.remove(deck.size()-1);
		dealerSum += hiddenCard.getValue();
		dealerAceCount += hiddenCard.isAce() ? 1 : 0;
		
		Card card =  deck.remove(deck.size()-1);
		dealerSum += card.getValue();
		dealerAceCount += card.isAce() ? 1 : 0;
		dealerHand.add(card);
		
		System.out.println("DEALER HAND: ");
		System.out.println(hiddenCard);
		System.out.println(dealerHand);
		System.out.println(dealerSum);
		System.out.println(dealerAceCount);
		
		playerHand = new ArrayList<Card>();
		playerSum = 0;
		playerAceCount = 0;
		
		for(int i =0;i < 2; i++) {
			 card = deck.remove(deck.size()-1);
			 playerSum += card.getValue();
			 playerAceCount += card.isAce() ? 1: 0;
			 playerHand.add(card);
		}
		
		System.out.println("PLAYER HAND: ");
		System.out.println(playerHand);
		System.out.println(playerSum);
		System.out.println(playerAceCount);
		
		
		
	}
	
	public void buildDeck() {
		
			deck = new ArrayList<Card>();
			String[] values = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
			String[] types = {"C","D","H","S"};
			
			for(int i = 0; i < types.length;i++) {
				for(int j = 0; j < values.length; j++) {
					Card card = new Card(values[j], types[i]);
					deck.add(card);
				}
			}
			System.out.println("built deck");
			System.out.println(deck);
		}
	
	public void shuffleDeck() {
		for(int i = 0; i < deck.size(); i++) {
			int j = rng.nextInt(deck.size());
			Card currCard = deck.get(i);
			Card RandomCard = deck.get(j);
			deck.set(i,RandomCard);
			deck.set(j, currCard);
		}
		System.out.println("shuffled deck");
		System.out.println(deck);
	}
	
}

