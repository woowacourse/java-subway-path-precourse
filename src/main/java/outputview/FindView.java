package outputview;

public class FindView implements Output{
    public static void printFindMenu(){
        System.out.println(HEAD + PATH_CRITERIA);
        System.out.println(SHORTEST_LENGTH);
        System.out.println(SMALLEST_TIME);
        System.out.println(BACK);
        System.out.println();
    }
}
