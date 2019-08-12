public class Change {
    private char fromCharacter;
    private char toCharacter;
    
    public Change(char fromCharacter, char toCharacter) {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }
    
    public String change(String characterString) {
        String modified = "";
        
        for (int i = 0; i < characterString.length(); i++) {
            if (characterString.charAt(i) == fromCharacter) {
                modified += toCharacter;
            } else {
                modified += characterString.charAt(i);
            }
        }
        
        return modified;
    }
}
