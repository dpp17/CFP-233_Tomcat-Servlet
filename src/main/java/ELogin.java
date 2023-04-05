public enum ELogin {
    USERNAME_START_WITH_CAPITAL("^[A-Z][A-Za-z]{3,}$");

    String constant;
    ELogin(String constant) {
        this.constant = constant;
    }

    public String getConstant(){
        return constant;
    }
}
