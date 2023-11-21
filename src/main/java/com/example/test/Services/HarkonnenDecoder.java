package com.example.test.Services;

public class HarkonnenDecoder implements MessageDecoder {
    @Override
    public String decode(String encodedMessage) {
        StringBuilder decodedMessage = new StringBuilder();

        for (char c : encodedMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                int diff = 'O' - 'M';
                char decodedChar = (char) (c - diff);
                decodedMessage.append(decodedChar);
            } else {
                switch (c) {
                    case '^':
                        decodedMessage.append("a");
                        break;
                    case '`':
                        decodedMessage.append("c");
                        break;
                    case ')':
                        decodedMessage.append(",");
                        break;
                    case '"', '\u001D':
                        decodedMessage.append(" ");
                        break;
                    default:
                        decodedMessage.append(c);
                }
            }
        }
        return decodedMessage.toString();
    }
}