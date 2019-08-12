package reader.criteria;

public class Both implements Criterion {
    private Criterion firstCriterion, secondCriterion;
    
    public Both(Criterion firstCriterion, Criterion secondCriterion) {
        this.firstCriterion = firstCriterion;
        this.secondCriterion = secondCriterion;
    }
    
    @Override
    public boolean complies(String line) {
        return (firstCriterion.complies(line) && secondCriterion.complies(line));
    }
    
}
