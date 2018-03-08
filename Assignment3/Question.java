
/**
 * class Question - creating the Question object
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.28, 2017
 */
public class Question
{
    private String question, answer;
    
    //create question object
    public Question(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
    }
    
    //methods to get questions and answers
    public String getAnswer()
    {
        return answer;
    }
    public String getQuestion()
    {
        return question;
    }
}
