/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astronaut_heroes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ath77
 */
@Entity
@Table(name="GAME")
public class Game implements java.io.Serializable {
    @Id
    @GeneratedValue
    @Column(name="gameID")
    private int gameID;
    @Column(name="gameName")
    private String gameName;
    @Column(name="score")
    private int score;
    @Column(name="userName")
    private String userName;
    

    public Game() {
    }

    public Game(int gameID, String gameName, int score, String userName) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.score = score;
        this.userName = userName;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
