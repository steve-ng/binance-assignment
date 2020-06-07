package com.binance.cms.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "page")
@Data
@SuperBuilder
@NoArgsConstructor
public class ArticleEntity extends BaseEntity {

    @Id
    @Column
    private String slug;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "page")
    @Builder.Default
    private List<ArticleTranslationEntity> translation = new ArrayList<>();

    public void removeTranslation(ArticleTranslationEntity articleTranslationEntity) {
        translation.remove(articleTranslationEntity);
    }

    public void addTranslation(ArticleTranslationEntity articleTranslationEntity) {
        translation.add(articleTranslationEntity);
        articleTranslationEntity.setPage(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ArticleEntity))
            return false;

        ArticleEntity other = (ArticleEntity) o;
        return Objects.equals(slug, other.getSlug());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(slug);
    }
}
