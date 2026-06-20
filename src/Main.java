import java.util.*;
class Options{
    void acceptOption(int a){
    switch(a) {// Menu for the user to perform a functionality
        case 1:
            System.out.println("Create Post");
            break;
        case 2:
            System.out.println("Edit Post");
            break;
        case 3:
            System.out.println("Delete Post");
            break;
        case 4:
            System.out.println("View Post");
            break;
        case 5:
            System.out.println("View all Posts");
            break;
        default:
            System.out.println("Invalid Option");
            break;
    }
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=0;
        System.out.println("Enter 1-To create a post,2-Edit a post, 3-Delete a post, 4-View a post, 5-View all posts");
        n=sc.nextInt();
        Options o=new Options();
        o.acceptOption(n);
    }
}