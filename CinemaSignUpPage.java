import java.awt.*;
import java.awt.event.*;

public class CinemaSignUpPage extends Frame implements ActionListener 
{
   private TextField usernameField;
   private TextField passwordField;

   public CinemaSignUpPage(){
      setTitle("Cinema Booking Signup");
      setSize(500,750);
      setLayout(null);
     
   //adding image
   Image popcornImage = Toolkit.getDefaultToolkit().getImage("popcorn.jpg");
   Image scaledPopcornImage = popcornImage.getScaledInstance(200,200,Image.SCALE_DEFAULT);
   add(new ImagePanel(scaledPopcornImage,150,50));

   //ading welcome label
   Label welcomeLabel = new Label("Welcome to Movie Mate");
   welcomeLabel.setFont(new Font("Arial",Font.BOLD,20));
   welcomeLabel.setBounds(150,270,300,30);
   add(welcomeLabel);

   //adding username field
   usernameField = new TextField();
   usernameField.setBounds(100,320,300,30);
   usernameField.setText("username");
   add(usernameField);
   
   //adding password field
   passwordField = new TextField();
   passwordField.setBounds(100,370,300,30);
   passwordField.setEchoChar('*');
   passwordField.setText("password");
   add(passwordField);

   //adding sign-in button
   Button signinButton = new Button("Sign In");
   signinButton.setBounds(200,420,100,30);
   signinButton.addActionListener(this);
   add(signinButton);

   //adding sign-up option
   Label SignupLabel = new Label("If you are new here.sign up now");
   SignupLabel.setBounds(150,470,200,20);
   add(SignupLabel);

   //adding sign-up button
   Button signupButton = new Button("Sign up");
   signupButton.setBounds(200,500,100,30);
   signupButton.addActionListener(this);
   add(signupButton);

   addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e){
         dispose();
      }
   });
   setVisible(true);
}

public void actionPerformed(ActionEvent e) {
   String usernameText = usernameField.getText();
   String passwordText = usernameField.getText();

        if (e.getActionCommand().equals("Sign In")) {
      //sign-in logic
      System.out.println("Signing in with username:"+usernameText+",password"+passwordText);
      }else if(e.getActionCommand().equals("sign up")){
         //sign-up logic
         System.out.println("Signing up with username:"+usernameText+",password"+passwordText);
       }
}
   public static void main(String[] args){
      new CinemaSignUpPage();
   }
}
class ImagePanel extends Panel{
   private Image image;
   private int width;
   private int height;

   public ImagePanel(Image image,int width,int height){
      this.image = image;
      this.width = width;
      this.height = height;
      setPreferredSize(new Dimension(width,height));
   }
      public void paint(Graphics g){
         super.paint(g);
         g.drawImage(image,0,0,width,height,this);
      }
}