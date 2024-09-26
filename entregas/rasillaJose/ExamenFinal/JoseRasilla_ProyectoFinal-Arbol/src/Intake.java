import structure.TreeNode;

public class Intake extends TreeNode {

    public String intakeDescription = "";

    public Intake(String description) {
        super(false, "Intake");
        this.intakeDescription = description;
    }
    
}