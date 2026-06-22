import java.util.*;
class Options{
    void acceptOption(int a, BlogService bs){
    switch(a) {// Menu for the user to perform a functionality
        case 1:
            System.out.println("Create Post");
            bs.createPost();
            break;
        case 2:
            System.out.println("Edit Post");
            bs.editPost();
            break;
        case 3:
            System.out.println("Delete Post");
            bs.deletePost();
            break;
        case 4:
            System.out.println("View Post");
            bs.viewPost();
            break;
        case 5:
            System.out.println("View all Posts");
            bs.viewAllPosts();
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
        BlogService bs= new BlogService();
        Options o=new Options();
        while(true){
            System.out.println("Enter 1-To create a post,2-Edit a post, 3-Delete a post, 4-View a post, 5-View all posts,6-Exit");
            int n=sc.nextInt();
            if(n==6){
                System.out.println("Exited successfully");
                break;
            }
            o.acceptOption(n,bs);
        }
    }
}