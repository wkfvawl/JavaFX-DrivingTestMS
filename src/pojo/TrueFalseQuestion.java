package pojo;

public class TrueFalseQuestion {
    String  number;//题目编号
    String content;//题目内容
    String pic;//图片名称
    String optionT;//选项
    String optionF;
    String answer;//正确答案

    public TrueFalseQuestion(String number, String content, String pic, String optionT, String optionF, String answer) {
        this.number = number;
        this.content = content;
        this.pic = pic;
        this.optionT = optionT;
        this.optionF = optionF;
        this.answer = answer;
    }
    public TrueFalseQuestion()
    {

    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getOptionT() {
        return optionT;
    }

    public void setOptionT(String optionT) {
        this.optionT = optionT;
    }

    public String getOptionF() {
        return optionF;
    }

    public void setOptionF(String optionF) {
        this.optionF = optionF;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "TrueFalseQuestion{" +
                "number='" + number + '\'' +
                ", content='" + content + '\'' +
                ", pic='" + pic + '\'' +
                ", optionT='" + optionT + '\'' +
                ", optionF='" + optionF + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
