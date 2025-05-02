package com.example.schduler_v2.schedule.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;

import com.example.schduler_v2.comment.entity.Comment;
import com.example.schduler_v2.common.BaseEntity;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scheduleId")
	private Long id;

	@Column(nullable = false)
	private String title;

	private String content;

	@Column(nullable = false)
	private Long userId;

	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
	private List<Comment> commentList;
}
