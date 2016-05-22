/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram;

import java.util.Scanner;

/**
 *
 * @author Vincent
 */
public class Telegram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Telegram().run();
    }

    private final int LetterQuestion = 1;
    private final int BasicChargeQuestion = 2;
    private final int extraChargeQuestion = 3;
    private final int taxQuestion = 4;
    private final int configuestion = 5;
    private Scanner input;
    private String letter;
    private int basicCharge = 10;
    private double extraCharge = 4;
    private int tax = 16;
    private double totalCharge = 0.0;

    public Telegram() {
        this.input = new Scanner(System.in);
    }

    public void run() {
        setLetter(getAnswer(getQuestion(LetterQuestion), 0));
        if (getConfigure(getQuestion(configuestion))) {
            setBasicCharge(getAnswer(getQuestion(BasicChargeQuestion)));
            setExtraCharge(getAnswer(getQuestion(extraChargeQuestion), 0, 0));
            setTax(getAnswer(getQuestion(taxQuestion)));
        }
        setTotalCharge(calTotalCharge());
        write("The charge for yout telegram is " + getTotalCharge());
    }

    private double calTotalCharge() {
        double charge = 0.0;
        int lettersnumber = getLetter().split(" ").length;
        if (lettersnumber <= 10) {
            charge = getBasicCharge();
        } else if (lettersnumber > 10) {
            charge = getBasicCharge();
            charge += (getExtraCharge() * (lettersnumber - 10));
        }
        double addedtax = charge * getTax() / 100;
        charge += addedtax;
        return charge;
    }

    private String getQuestion(int id) {
        String question = null;
        if (IdsEqual(id, LetterQuestion)) {
            question = "Enter the Telegram to be charged as string";
        }
        if (IdsEqual(id, BasicChargeQuestion)) {
            question = "Enter the basic charge for the first 10 words";
        }
        if (IdsEqual(id, extraChargeQuestion)) {
            question = "Enter the extra charge for extra word after 10 words";
        }
        if (IdsEqual(id, taxQuestion)) {
            question = "Enter the tax to be charged for this telegram";
        }
        if (IdsEqual(id, configuestion)) {
            question = "Would you like to set parameters? Y/N";
        }
        return question;
    }

    private boolean IdsEqual(int id1, int id2) {
        return id1 == id2;
    }

    private int getAnswer(String question) {
        write(question);
        return getInput().nextInt();
    }

    protected String getAnswer(String question, int t) {
        write(question);
        return getInput().nextLine();
    }
    
    private double getAnswer(String question, int t, int a) {
        write(question);
        return getInput().nextDouble();
    }

    private boolean getConfigure(String question) {
        String ans = getAnswer(question, 0);
        return ans.equals("Y") || ans.equals("y");
    }

    private void write(String s) {
        System.out.println(s);
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getBasicCharge() {
        return basicCharge;
    }

    public void setBasicCharge(int basicCharge) {
        this.basicCharge = basicCharge;
    }

    public double getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(double extraCharge) {
        this.extraCharge = extraCharge;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public Scanner getInput() {
        return input;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

}
