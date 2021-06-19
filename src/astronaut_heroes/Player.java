/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astronaut_heroes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ath77
 */

@Entity
@Table(name="PLAYER")//@SecondaryTable(name="GAME", pkJoinColumns = @PrimaryKeyJoinColumn(name = "userName", referencedColumnName = "userName"))
public class Player  implements java.io.Serializable {
    
    @Id
    @Column(name="userName")
    private String userName;
    @Column(name="age")
    private String age;
    @Column(name="total_score")
    private int total_score;
    @Column(name="password") 
    private String password;

    public Player() {
    }

    public Player(String userName, String age, int total_score, String password) {
        this.userName = userName;
        this.age = age;
        this.total_score = total_score;
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    @Override
    public String toString() {
        return "Player{" + "userName=" + userName + ", age=" + age + ", total_score=" + total_score + ", password=" + password + '}';
    }
    
    
}
