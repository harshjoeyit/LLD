package DesignPatterns.ChainOfResponsibility;

public class Level2Support extends BaseHandler {
    
    @Override
    public void handleRequest(String request) {
        if ("complex query".equals(request)) {
            System.out.println("Level 2 Support: Handled the request");
        } else {
            System.out.println("Level 2 Support: Passing request to Level 3");
            super.handleRequest(request);
        }
    }
}
