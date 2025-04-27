public void connectToServer() {
    System.out.println("Connecting to " + serverIp + " on port " + serverPort);
    System.out.println("Username: " + username);
    System.out.println("Selected Color: " + selectedColor);

    JFrame frame = new JFrame("Chat Window - " + username);
    frame.setSize(500, 400);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.getContentPane().setBackground(selectedColor);

    // Chat area
    JTextArea chatArea = new JTextArea();
    chatArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(chatArea);
    
    // Message input panel
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new BorderLayout());
    inputPanel.setBackground(selectedColor);

    JTextField messageField = new JTextField();
    JButton sendButton = new JButton("Send");

    inputPanel.add(messageField, BorderLayout.CENTER);
    inputPanel.add(sendButton, BorderLayout.EAST);

    frame.add(scrollPane, BorderLayout.CENTER);
    frame.add(inputPanel, BorderLayout.SOUTH);

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    // Action for send button
    sendButton.addActionListener(e -> {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            chatArea.append(username + ": " + message + "\n");
            messageField.setText("");
        }
    });
}
