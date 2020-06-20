package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

public class PostId {
    private Integer userId;
    private Integer studyGroupId;

    public int hashCode() {
        return (int)(userId + studyGroupId);
    }

    public boolean equals(Object object) {
        if (object instanceof PostId) {
            PostId otherId = (PostId) object;
            return (otherId.userId == this.userId) && (otherId.studyGroupId == this.studyGroupId);
        }
        return false;
    }
}