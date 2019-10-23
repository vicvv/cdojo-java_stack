import java.util.ArrayList;
public class Portfolio{
    
    ArrayList<Project> projects = new ArrayList<Project>();
    
    public Portfolio(){ }
    
    public void addProject(Project myProject){
        this.projects.add(myProject);
    }

   
    public double getPortfolioCost(){
        double totalCost = 0;
        for (Project project: this.projects){
            totalCost += project.getProjectCost();
        }
        return totalCost;
    }
    
    public void showPortfolio(){
        System.out.println("Portfolio Projects");
        for (Project project: this.projects){
            System.out.println(project.projectInfo());
        }
        System.out.println("Portfolio total cost:" + this.getPortfolioCost());
    }
}