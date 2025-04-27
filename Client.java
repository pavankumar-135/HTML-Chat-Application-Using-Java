import java.awt.*;
import javax.swing.*;

public class Client {
    private String serverIp;
    private int serverPort;
    private String username;
    private Color selectedColor;

    public Client(String serverIp, int serverPort, String username, Color selectedColor) {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.username = username;
        this.selectedColor = selectedColor;
    }

    public void connectToServer() {
        System.out.println("Connecting to " + serverIp + " on port " + serverPort);
        System.out.println("Username: " + username);
        System.out.println("Selected Color: " + selectedColor);

        // 🖼 Create a Chat Window
        JFrame frame = new JFrame("Chat Window - " + username);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Background color
        frame.getContentPane().setBackground(selectedColor);

        // 📝 Text area (for chat messages)
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        // 🖊 Input field and button
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(selectedColor);

        JTextField messageField = new JTextField();
        JButton sendButton = new JButton("Send");

        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // 🛠 Add to frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null); // Center window
        frame.setVisible(true);

        // ➡ Action when clicking "Send"
        sendButton.addActionListener(e -> {
            String message = messageField.getText().trim();
            if (!message.isEmpty()) {
                chatArea.append(username + ": " + message + "\n");
                messageField.setText("");
            }
        });

        // ➡ Also send message on ENTER key
        messageField.addActionListener(e -> {
            sendButton.doClick();
        });
    }
}
