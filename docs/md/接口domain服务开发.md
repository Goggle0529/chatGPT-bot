json2entity：https://www.sojson.com/json2entity.html - 用于对象转换

==================================
package ;
public class Group
{
private int group_id;

    private String name;

    private String type;

    private String background_url;

    public void setGroup_id(int group_id){
        this.group_id = group_id;
    }
    public int getGroup_id(){
        return this.group_id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setBackground_url(String background_url){
        this.background_url = background_url;
    }
    public String getBackground_url(){
        return this.background_url;
    }
}

==================================
package ;
public class Owner
{
private int user_id;

    private String name;

    private String avatar_url;

    private String location;

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }
    public int getUser_id(){
        return this.user_id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAvatar_url(String avatar_url){
        this.avatar_url = avatar_url;
    }
    public String getAvatar_url(){
        return this.avatar_url;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return this.location;
    }
}

==================================
package ;
public class Questionee
{
private int user_id;

    private String name;

    private String avatar_url;

    private String location;

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }
    public int getUser_id(){
        return this.user_id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAvatar_url(String avatar_url){
        this.avatar_url = avatar_url;
    }
    public String getAvatar_url(){
        return this.avatar_url;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return this.location;
    }
}

==================================
package ;
public class Owner_detail
{
private int questions_count;

    private String join_time;

    public void setQuestions_count(int questions_count){
        this.questions_count = questions_count;
    }
    public int getQuestions_count(){
        return this.questions_count;
    }
    public void setJoin_time(String join_time){
        this.join_time = join_time;
    }
    public String getJoin_time(){
        return this.join_time;
    }
}

==================================
package ;
public class Question
{
private Owner owner;

    private Questionee questionee;

    private String text;

    private boolean expired;

    private boolean anonymous;

    private Owner_detail owner_detail;

    private String owner_location;

    public void setOwner(Owner owner){
        this.owner = owner;
    }
    public Owner getOwner(){
        return this.owner;
    }
    public void setQuestionee(Questionee questionee){
        this.questionee = questionee;
    }
    public Questionee getQuestionee(){
        return this.questionee;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setExpired(boolean expired){
        this.expired = expired;
    }
    public boolean getExpired(){
        return this.expired;
    }
    public void setAnonymous(boolean anonymous){
        this.anonymous = anonymous;
    }
    public boolean getAnonymous(){
        return this.anonymous;
    }
    public void setOwner_detail(Owner_detail owner_detail){
        this.owner_detail = owner_detail;
    }
    public Owner_detail getOwner_detail(){
        return this.owner_detail;
    }
    public void setOwner_location(String owner_location){
        this.owner_location = owner_location;
    }
    public String getOwner_location(){
        return this.owner_location;
    }
}

==================================
package ;
public class User_specific
{
private boolean liked;

    private boolean subscribed;

    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }
}

==================================
package ;
public class Topics
{
private int topic_id;

    private Group group;

    private String type;

    private Question question;

    private boolean answered;

    private int likes_count;

    private int rewards_count;

    private int comments_count;

    private int reading_count;

    private int readers_count;

    private boolean digested;

    private boolean sticky;

    private String create_time;

    private User_specific user_specific;

    public void setTopic_id(int topic_id){
        this.topic_id = topic_id;
    }
    public int getTopic_id(){
        return this.topic_id;
    }
    public void setGroup(Group group){
        this.group = group;
    }
    public Group getGroup(){
        return this.group;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setQuestion(Question question){
        this.question = question;
    }
    public Question getQuestion(){
        return this.question;
    }
    public void setAnswered(boolean answered){
        this.answered = answered;
    }
    public boolean getAnswered(){
        return this.answered;
    }
    public void setLikes_count(int likes_count){
        this.likes_count = likes_count;
    }
    public int getLikes_count(){
        return this.likes_count;
    }
    public void setRewards_count(int rewards_count){
        this.rewards_count = rewards_count;
    }
    public int getRewards_count(){
        return this.rewards_count;
    }
    public void setComments_count(int comments_count){
        this.comments_count = comments_count;
    }
    public int getComments_count(){
        return this.comments_count;
    }
    public void setReading_count(int reading_count){
        this.reading_count = reading_count;
    }
    public int getReading_count(){
        return this.reading_count;
    }
    public void setReaders_count(int readers_count){
        this.readers_count = readers_count;
    }
    public int getReaders_count(){
        return this.readers_count;
    }
    public void setDigested(boolean digested){
        this.digested = digested;
    }
    public boolean getDigested(){
        return this.digested;
    }
    public void setSticky(boolean sticky){
        this.sticky = sticky;
    }
    public boolean getSticky(){
        return this.sticky;
    }
    public void setCreate_time(String create_time){
        this.create_time = create_time;
    }
    public String getCreate_time(){
        return this.create_time;
    }
    public void setUser_specific(User_specific user_specific){
        this.user_specific = user_specific;
    }
    public User_specific getUser_specific(){
        return this.user_specific;
    }
}

==================================
package ;
import java.util.ArrayList;
import java.util.List;
public class Resp_data
{
private List<Topics> topics;

    public void setTopics(List<Topics> topics){
        this.topics = topics;
    }
    public List<Topics> getTopics(){
        return this.topics;
    }
}

==================================
package ;
public class Root
{
private boolean succeeded;

    private Resp_data resp_data;

    public void setSucceeded(boolean succeeded){
        this.succeeded = succeeded;
    }
    public boolean getSucceeded(){
        return this.succeeded;
    }
    public void setResp_data(Resp_data resp_data){
        this.resp_data = resp_data;
    }
    public Resp_data getResp_data(){
        return this.resp_data;
    }
}
