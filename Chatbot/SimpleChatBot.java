import java.util.HashMap;
import java.util.Scanner;

public class SimpleChatBot {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> responses = new HashMap<>();

        // Predefined responses
        responses.put("hi", "Hello! How can I help you?");
        responses.put("hello", "Hi there! What can I do for you?");
        responses.put("how are you", "I'm just a bot, but I'm doing great! How about you?");
        responses.put("bye", "Goodbye! Have a nice day.");
        responses.put("what is your name", "I'm ChatBot, your virtual assistant.");
        responses.put("who created you", "I was created by a Java programmer!");
        responses.put("who is java programmer", "Vinod");
        responses.put("default", "I'm not sure how to respond to that.");

        System.out.println("ChatBot: Hello! Type 'bye' to exit.");
        
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("bye")) {
                System.out.println("ChatBot: " + responses.get("bye"));
                break;
            }

            // Check if the response exists, otherwise use default response
            String response = responses.getOrDefault(userInput, responses.get("default"));
            System.out.println("ChatBot: " + response);
        }

        scanner.close();
    }
}
