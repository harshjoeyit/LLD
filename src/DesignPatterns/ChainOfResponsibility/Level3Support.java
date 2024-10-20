package DesignPatterns.ChainOfResponsibility;

class Level3Support extends BaseHandler {
    
    @Override
    public void handleRequest(String request) {
        System.out.println("Level 3 Support: Handled the request");
    }
}
