import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
class BlogService{
    ArrayList<Post> Posts= new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    int nextId=1;// Counter variable for number of posts which prevents duplication of post IDs
    void createPost(){
        int id=nextId++;
        System.out.println("Enter your title:");
        String title=sc.nextLine();
        System.out.println("Enter the category of your post:");
        String category=sc.nextLine();
        System.out.println("Enter the contents of your post here:");
        String content=sc.nextLine();
        String date= LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yy"));
        Post p=new Post(id,date,category,title,content);
        Posts.add(p);
        System.out.println("Your post has been created successfully!");
    }
    void editPost(){
        System.out.println("Enter the post ID of the post you wish to edit:");
        int editID=sc.nextInt();
        boolean found=false;
        for(Post p:Posts){
            if(p.id==editID){
                found=true;
                System.out.println("------------------------------");
                System.out.println("Edited Content:");
                p.content=sc.next();break;

            }
            if(!found){
                System.out.println("Please re-check the post ID, a post with the entered ID does not exist");
            }

        }
    }
    void deletePost(){
        System.out.println("Enter the post ID of the post you wish to delete:");
        int delID=sc.nextInt();
        sc.nextLine();
        boolean found=false;
        for(int i=0;i<Posts.size();i++){
            if(Posts.get(i).id==delID) {//Searches through all Posts IDs until it finds the required one
                Posts.remove(i);//Removes that post object from the ArrayList
                found=true;
                System.out.println("Post deleted successfully");
                break;
            }
            if(!found) {
                System.out.println("Please re-check the post ID, a post with the entered ID does not exist");
            }
        }
    }
    void viewPost(){
        System.out.println("Enter the post ID of the post you wish to view:");
        int viewID=sc.nextInt();
        boolean found=false;
        for(Post p:Posts){
            if(p.id==viewID){
                found=true;
                System.out.println("------------------------------");
                System.out.println("ID: "+p.id);
                System.out.println("Date: "+p.date);
                System.out.println("Category: "+p.category);
                System.out.println("Title: "+p.title);
                System.out.println("Content: "+p.content);
                break;
            }
            if(!found){
                System.out.println("Please re-check the post ID, a post with the entered ID does not exist");
            }

        }

    }
    void viewAllPosts(){
        for(Post p:Posts){
            System.out.println("------------------------------");
            System.out.println("ID: "+p.id);
            System.out.println("Date: "+p.date);
            System.out.println("Category: "+p.category);
            System.out.println("Title: "+p.title);
            System.out.println("Content: "+p.content);
        }
    }
}