public class Project{
    private String name;
    private String description;
    private double cost;
    public Project() {
        //this("Project Name", "Project Description");
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Project(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
    //getters

    public String getProjectName(){
        return this.name;
    }
    public String getProjectDescription(){
        return this.description;
    }
    public double getProjectCost(){
        return this.cost;
    }

    //setters

    public void setProjectName(String name){
        this.name = name;
    }

    public void setProjectDescription(String description){
        this.description = description;
    }

    public void setProjectCost (double cost){
        this.cost = cost;
    }
    //summary

    public String projectInfo(){
        return (name + " " + cost + " " + description); 
     }
}