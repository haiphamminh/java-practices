package com.example.pattern;

public class ChainOfResponsibility {

    public static void main(String[] args) {
        AuthenticationProcessor ap = getChainOfAuthProcessor();
        AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
        System.out.println(authProcessorChain.isAuthorized(new OAuthTokenProvider()));

        System.out.println(authProcessorChain.isAuthorized(new UsernamePasswordProvider()));

        System.out.println(authProcessorChain.isAuthorized(new SamlTokenProvider()));
    }

    private static AuthenticationProcessor getChainOfAuthProcessor() {
        AuthenticationProcessor oAuthProcessor = new OAuthProcessor(null);
        return new UsernamePasswordProcessor(oAuthProcessor);
    }

    private static abstract class AuthenticationProcessor {
        public AuthenticationProcessor nextProcessor;

        public AuthenticationProcessor(AuthenticationProcessor nextProcessor) {
            this.nextProcessor = nextProcessor;
        }

        protected boolean isAuthorized(AuthenticationProvider authProvider) {
            if (isAuthorizedByProcessor(authProvider)) {
                return true;
            }
            if (nextProcessor != null) {
                return nextProcessor.isAuthorized(authProvider);
            }
            return false;
        }

        protected abstract boolean isAuthorizedByProcessor(AuthenticationProvider authProvider);
    }

    private static class OAuthProcessor extends AuthenticationProcessor {

        public OAuthProcessor(AuthenticationProcessor nextProcessor) {
            super(nextProcessor);
        }

        @Override
        protected boolean isAuthorizedByProcessor(AuthenticationProvider authProvider) {
            return (authProvider instanceof OAuthTokenProvider);
        }
    }

    private static class UsernamePasswordProcessor extends AuthenticationProcessor {

        public UsernamePasswordProcessor(AuthenticationProcessor nextProcessor) {
            super(nextProcessor);
        }

        @Override
        protected boolean isAuthorizedByProcessor(AuthenticationProvider authProvider) {
            return (authProvider instanceof UsernamePasswordProvider);
        }
    }

    private interface AuthenticationProvider {

    }

    private static class OAuthTokenProvider implements AuthenticationProvider {}

    private static class UsernamePasswordProvider implements AuthenticationProvider {}

    private static class SamlTokenProvider implements AuthenticationProvider {}
}
