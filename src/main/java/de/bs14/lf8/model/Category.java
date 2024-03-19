package de.bs14.lf8.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Category")
@Getter
@ToString
@NoArgsConstructor
@Setter
public class Category {

  public Category(String categoryName) {
    this.categoryName = categoryName;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CategoryID")
  private int categoryId;

  @Column(name = "CategoryName")
  private String categoryName;
}
