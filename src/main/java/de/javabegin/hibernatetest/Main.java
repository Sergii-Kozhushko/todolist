package de.javabegin.hibernatetest;

import de.javabegin.hibernatetest.dao.impl.StatDAOImpl;
import de.javabegin.hibernatetest.entity.Stat;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {

        //        СЦЕНАРИЙ #1 (один из множества вариантов - можете придумать свой):
//        создаем пользователя (триггеры создадут сразу же тестовые данные)
//        активируем пользователя (поле activated)
//        создаем новую категорию
//        создаем новый приоритет
//        создаем несколько новых задач (помимо тестовых) с новыми категорией и приоритетом
//        завершаем задачу
//        удаляем задачу
//        считываем статистику по любой категории пользователя
//        считываем общую статистику пользователя

        //User user = new User();
        //UserDAOImpl userDAO = new UserDAOImpl();
//        user.setUsername("Scenario 1 user");
//        user.setPassword("some pass");
//        user.setEmail("scnuser1@gmail.com");
//        userDAO.add(user);

        //user = userDAO.getByEmail("scnuser1@gmail.com");

//        Activity activity = new Activity();
//        activity.setUser(user);
//        activity.setActivated(true);
//        ActivityDAOImpl activityDAO = new ActivityDAOImpl();
//        Activity activity = activityDAO.getByUser(user);
//        activity.setActivated(true);
//        activityDAO.update(activity);

//        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
//        PriorityDAOImpl priorityDAO = new PriorityDAOImpl();
//        Category category = new Category();
//        category.setTitle("Категория для тест сценария 1");
//        category.setUser(user);
//        categoryDAO.add(category);
//        Priority priority = new Priority();
//        priority.setUser(user);
//        priority.setTitle("Высокий");
//        priority.setColor("#FF0000");
//        priorityDAO.add(priority);
//
//        Task task = new Task();
//        task.setUser(user);
//        task.setTitle("Таск для сценария 1");
//        task.setTaskDate(new Date());
//        task.setCategory(category);
//        task.setPriority(priority);
//        task.setCompleted(false);
//        TaskDAOImpl taskDAO = new TaskDAOImpl();
//        taskDAO.add(task);

        // завершить задачу
//        User user = new User();
//        UserDAOImpl userDAO = new UserDAOImpl();
//        user = userDAO.getByEmail("scnuser1@gmail.com");
//        TaskDAOImpl taskDAO = new TaskDAOImpl();
//        List<Task> tasklist = taskDAO.findAll("scnuser1@gmail.com");
//        for (int i = 0; i < tasklist.size() ; i++) {
//            Task task = tasklist.get(i);
//            if (task.getTitle().equals("Таск для сценария 1")){
//                task.setCompleted(true);
//                taskDAO.delete(task.getId());
//            }
//        }
//        UserDAOImpl userDAO = new UserDAOImpl();
//        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
//        User user = userDAO.getByEmail("scnuser1@gmail.com");
//        List<Category> categoryList = categoryDAO.findAll(user.getEmail());
//        for (int i = 0; i < categoryList.size() ; i++) {
//            log.info(categoryList.get(i));
//        }
        //category = categoryDAO.findAll("scnuser1@gmail.com");
        //Category category = categoryDAO.get(73520L);
        //log.info(category);

        StatDAOImpl statDAO = new StatDAOImpl();
        Stat stat = statDAO.getByUser("scnuser1@gmail.com");
        //log.info(stat);

        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);
        logger.info("Stat {} - {}", stat.getCompletedTotal(), stat.getUncompletedTotal());









        log.info("Hibernate info message");
        //log.warn("Hibernate warn message");


        // CriteriaBuilder
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//
//        // Запрос Select Criteria API
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.select(root);// запрос select из таблицы user_data
//        //criteriaQuery.select(root).where(criteriaBuilder.gt(root.get("id"), 10000));
//        Predicate p1 = criteriaBuilder.gt(root.get("id"), 5600 );
//        Predicate p2 = criteriaBuilder.lt(root.get("id"), 6000);
//        criteriaQuery.select(root).where(criteriaBuilder.and(p1, p2));
//
//        // выполнение запроса с получением результата
//        Query query = session.createQuery(criteriaQuery);
//        List<User> results = query.getResultList();
//        for (User u : results){
//            System.out.printf("id=%s, name=%s%n", u.getId(), u.getUsername());
//        }
        // Delete Criteria API
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaDelete<User> criteriaDelete = cb.createCriteriaDelete(User.class);
//        Root<User> root = criteriaDelete.from(User.class);
//        criteriaDelete.where(cb.equal(root.get("id"), 5614));
//
//        Transaction transaction = session.beginTransaction();
//        session.createMutationQuery(criteriaDelete).executeUpdate();
//        transaction.commit();

        // HQL - Select  WHERE простой запрос
//        Query query = session.createQuery("from User u where u.id=:text and email like :email", User.class);
//        query.setParameter("text", "1001");
//        query.setParameter("email", "%1%");
//        List<User> users = query.getResultList();
//         log.info(users.toString());

        // HQL - Select  постраничный запрос
//        Query query = session.createQuery("from User", User.class);
//        //query.setParameter("text", "1001");
//        query.setFirstResult(90);
//        query.setMaxResults(12);
//        List<User> users = query.getResultList();
//        log.info(users.size());

            // Получение одной записи
//        Query query = session.createQuery("from User u where u.id=:text ", User.class);
//        query.setParameter("text", "1001");
//        User user = (User) query.uniqueResult(); // Query должен быть обязательно из пакета хибернейт
//        log.info(user.getUsername());

        // агрегатные запросы
//        Query<Long> query = session.createQuery("select count(u.id) from User u where u.username like :text ", Long.class);
//        query.setParameter("text", "%101%");
//        Long count = query.getSingleResult();
//        log.info(count);

        // выборка только двух полей
//        Query<User> query = session.createQuery("select new User(u.email, u.username) from User u where u.id =:text", User.class);
//        query.setParameter("text", "1001");
//        User user = query.getSingleResult();
//        log.info(user.toString());

        // Запрос со стандартным SQL-ем
//        String qry = "Select * from todolistm.user_data";
//        NativeQuery sqlQuery = session.createNativeQuery(qry,User.class);
//        sqlQuery.setMaxResults(10);
//        List<User> users = sqlQuery.list();
//        log.info(users.size());

        // Станадартный SQL - получение результата в массив обдежктов
//        NativeQuery<Object[]> query = session.createNativeQuery("select " +
//                "       count(u.id), " +
//                "       substring(u.email, position('@' in u.email)+1, length(u.email)) as domainemail " +
//                "from todolistm.user_data u  " +
//                "where u.email like '%@%' " +
//                "group by substring(u.email, position('@' in u.email)+1, length(u.email))", Object[].class);
//        log.info(query.getResultList().size());
//        for (Object[] obj: query.getResultList()) {
//            log.info(obj[0]);
//            log.info(obj[1]);
//            log.info("-----");
//        }


        // Lazy данные Priority и категории
        //Query query = session.createQuery("from User", User.class);
        //query.setParameter("text", "1001");
        //query.setFirstResult(90);
        //query.setMaxResults(12);
        //List<User> users = query.getResultList();
        //users.get(0).getPriorities();
        //log.info(users.get(0).getCategories());

        // Получение данных @ManyToOne, данные по юзеру берутся из кеша. Для каждо1 категории не вызвается запрос на каждого юзера
//        Query query = session.createQuery("from Category", Category.class);
//        query.setMaxResults(10);
//        List<Category> categoryList = query.getResultList();
//        for (Category c : categoryList){
//            log.info(c.getTitle() + " " + c.getUser().getId());
//        }

        // Получение данных по стат и активити
//        Query query = session.createQuery("from User", User.class);
//        query.setMaxResults(2);
//        List<User> userList = query.getResultList();
//        for (User u : userList){
//            log.info(u);
//        }
//        for (Role r : userList.get(1).getRoles()){
//            log.info(r.getName());
//        }
        //log.info(userList.get(0).getRoles());

        // Кеш 2-го уровня
//        User u1 = session.get(User.class, 100L);
//        log.info(u1);
//        session.close();// закрыть сессию
//
//        session = HibernateUtil.getSessionFactory().openSession();
//        User u2 = session.get(User.class, 100L);
//        log.info(u2);
//
//        session.close();// закрыть сессию
//        log.info("hit: " + HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
//        log.info("miss: " + HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheMissCount());
//        log.info("put: " + HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCachePutCount());
//        log.info("names: " + Arrays.toString(HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheRegionNames()));
//        log.info("open: " + HibernateUtil.getSessionFactory().getStatistics().getSessionOpenCount());

        // DELETE
//        session.beginTransaction();
//        //User u1 = session.get(User.class, 100L);
//        User u1 = new User();
//        u1.setId(102L);
//        session.remove(u1);
//        session.getTransaction().commit();

        // FLUSH
//        session.beginTransaction();
//        for (int i = 0; i < 10_0 ; i++) {
//            User user = new User();
//            user.setUsername("username" + i);
//            user.setPassword("sssss");
//            user.setEmail("wenfjuwbfewef");
//            session.persist(user);
//            if (i % 100 == 0)
//                session.flush();
////        }
        //session.getTransaction().rollback();

        // INSERT
//        session.beginTransaction();
//        User u1 = session.get(User.class, 104L);
//         log.info(u1);
//         Role r1 = session.get(Role.class, 1);
//        Role r2 = session.get(Role.class, 3);
//        User u = new User();
//        u.setUsername("Mary Gold Pikins");
//        u.setEmail("pikkins@yahoo.com");
//        u.setPassword("pass");
//        u.getRoles().add(r1);
//        u.getRoles().add(r2);
//        session.persist(u);
//        session.getTransaction().commit();


        //Category c1 = session.get(Category.class, 2831L);
        //log.info(c1.getTitle());
//        Task t1 = session.get(Task.class, 337L);
//        log.info(t1.getUser());
//session.close();
        //HibernateUtil.close(); // закрыть Session Factory

        // DAO
//        UserDAOImpl userDAO = new UserDAOImpl();
//        //userDAO.delete(13L);
//        log.info(userDAO.findAll("mail.com").size());

//        TaskDAOImpl taskDAO = new TaskDAOImpl();
//        List<Task> list = taskDAO.find(true, "493@gmail.com");
//        log.info("s=" + taskDAO.find(true, "493@gmail.com").size());
//        log.info("test");



        //HibernateUtil.close(); // закрыть Session Factory


    }
}