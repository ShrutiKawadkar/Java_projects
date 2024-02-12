import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) 
        {
            balance -= amount;
            return true;
        } else 
        {
            return false;
        }
    }
}

class ATM extends JFrame implements ActionListener {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
        setTitle("ATM Machine");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton transactionButton = new JButton("Transaction");
        transactionButton.setFont(new Font("Arial", Font.BOLD, 20));
        transactionButton.addActionListener(this);
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.addActionListener(this);

        panel.add(transactionButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Transaction")) {
            String[] options = {"Withdraw", "Deposit", "Check Balance"};
            int choice = JOptionPane.showOptionDialog(this, "Select Transaction", "Transaction", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0: // Withdraw
                    String amountTextW = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
                    if (amountTextW == null)
                    return; // Cancel button pressed
                    double amountW = 0;
                    try {
                        amountW = Double.parseDouble(amountTextW);
                    } 
                    catch (NumberFormatException ex)
                     {
                        JOptionPane.showMessageDialog(this, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (account.withdraw(amountW)) {
                        JOptionPane.showMessageDialog(this, "Withdrawal successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Insufficient balance!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1: // Deposit
                    String amountTextD = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
                    if (amountTextD == null) return; // Cancel button pressed
                    double amountD = 0;
                    try {
                        amountD = Double.parseDouble(amountTextD);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    account.deposit(amountD);
                    JOptionPane.showMessageDialog(this, "Deposit successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2: // Check Balance
                    JOptionPane.showMessageDialog(this, "Your balance is: $" + account.getBalance(), "Balance", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } else if (e.getActionCommand().equals("Exit")) {
            JOptionPane.showMessageDialog(this, "Thank you for using the ATM!", "Exit", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        new ATM(account);
    }
}