public class Feat extends Attribute{
    private String prereq;
    public Feat(){
        super();
    }
    public Feat(String name, String desc, String src, String prereq, Modifier[] modifiers){
        super(name, desc, src, modifiers);
        this.prereq = prereq;
    }
    //prereq
    public String getPreReqs(){
        return this.prereq;
    }
    public void setPreReqs(String prereq){
        this.prereq=prereq;
    }
}