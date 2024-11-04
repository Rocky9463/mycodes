public class stdfunc {
    public static String standardize(String text){
        String lowerCaseText = text.toLowerCase();
        String cleanedText = lowerCaseText.replaceAll("\\W", "");
        return cleanedText;
    }
}
