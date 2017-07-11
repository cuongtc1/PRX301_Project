package dao;

import entities.Chapter;
import entities.ChapterPage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ultis.Ultilities;

public class ChapterPageDAO {

  public static ChapterPage getChapterPage(int id) {
    EntityManager em = Ultilities.getEntityManager();
    ChapterPage cp = null;

    try {
      TypedQuery<ChapterPage> query = em.createNamedQuery(
              "ChapterPage.findById", ChapterPage.class);
      query.setParameter("id", id);

      cp = query.getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      em.close();
    }

    return cp;
  }

  public static List<ChapterPage> getChapterPageByChapterId(int chapterId) {
    EntityManager em = Ultilities.getEntityManager();
    List<ChapterPage> result = null;

    try {
      TypedQuery<ChapterPage> query = em.createQuery(
              "SELECT c FROM ChapterPage c WHERE c.chapterId = :chapterId",
              ChapterPage.class);
      query.setParameter("chapterId", new Chapter(chapterId));

      result = query.getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      em.close();
    }

    return result;
  }

  public static int createChapterPage(ChapterPage cp) {
    EntityManager em = Ultilities.getEntityManager();

    try {
      em.getTransaction().begin();
      em.persist(cp);
      em.flush();
      em.getTransaction().commit();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      em.close();
    }

    return cp.getId();
  }

}
