package by.artezio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "session")
public class Session implements Serializable {

    @Id
    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "user_id")
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    public Session() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
