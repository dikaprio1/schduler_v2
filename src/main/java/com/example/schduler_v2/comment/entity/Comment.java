package com.example.schduler_v2.comment.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.example.schduler_v2.common.BaseEntity;
import com.example.schduler_v2.schedule.entity.Schedule;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@Column(nullable = false)
	private Long writerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	// 부모 댓글
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Comment parent;

	// 자식 댓글 (대댓글)
	@OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
	private Comment children;

	public Comment(String content, Long writerId, Schedule schedule, Comment parent) {
		this.content = content;
		this.writerId = writerId;
		this.schedule = schedule;
		this.parent = parent;
	}

	public void updateContent(String content) {
		this.content = content;
	}
}
