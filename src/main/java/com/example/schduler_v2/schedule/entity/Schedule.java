package com.example.schduler_v2.schedule.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

import com.example.schduler_v2.comment.entity.Comment;
import com.example.schduler_v2.common.BaseEntity;
import com.example.schduler_v2.schedule.dto.ScheduleRequestDto;
import com.example.schduler_v2.schedule.dto.ScheduleUpdateRequestDto;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private Long id;

	@Column(nullable = false)
	private String title;

	private String content;

	@Column(nullable = false)
	private Long writerId;

	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();;

	public Schedule(Long userId, String content, String title) {
		this.writerId = userId;
		this.content = content;
		this.title = title;
	}

	public void updateTitle(ScheduleUpdateRequestDto requestDto){
		this.title = requestDto.getTitle();
	}
	public void updateContent(ScheduleUpdateRequestDto requestDto){
		this.content = requestDto.getContent();
	}
}
