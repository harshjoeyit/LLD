package DesignPatterns.ChainOfResponsibility;

public class Level1Support extends BaseHandler {
    
    @Override
    public void handleRequest(String request) {
        if ("simple query".equals(request)) {
            System.out.println("Level 1 Support: Handled the request");
        } else {
            System.out.println("Level 1 Support: Passing request to Level 2");
            super.handleRequest(request);
        }
    }
}
