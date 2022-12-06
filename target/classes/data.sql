INSERT INTO role(creation_date_time, update_date_time, name) VALUES (NOW(), NOW(), 'ADMIN');
INSERT INTO role(creation_date_time, update_date_time, name) VALUES (NOW(), NOW(), 'USER');


INSERT INTO users(creation_date_time, update_date_time, username, password) VALUES (NOW(), NOW(), 'ADMIN', '$2a$10$IXnGAGjyHUW2f7O4fGEziejUNfqDRZ.6hFh6RKakp03v266vXiljy');
INSERT INTO users_roles(users_id, roles_id) VALUES (1, 1);


INSERT INTO course_type(creation_date_time, update_date_time, name) VALUES (NOW(), NOW(), 'name 1');
INSERT INTO address(creation_date_time, update_date_time, country, city, street, house) VALUES (NOW(), NOW(), 'country 1', 'city 1', 'street 1', 'house 1');
INSERT INTO course(creation_date_time, update_date_time, name, picture, url, description, address_id, course_type_id) VALUES (NOW(), NOW(), 'name', 'picture 1', 'url 1', 'description 1', 1, 1);

INSERT INTO course_type(creation_date_time, update_date_time, name) VALUES (NOW(), NOW(), 'name 2');
INSERT INTO address(creation_date_time, update_date_time, country, city, street, house) VALUES (NOW(), NOW(), 'country 2', 'city 2', 'street 2', 'house 2');
INSERT INTO course(creation_date_time, update_date_time, name, picture, url, description, address_id, course_type_id) VALUES (NOW(), NOW(), 'name', 'picture 2', 'url 2', 'description 2', 2, 2);

INSERT INTO question(creation_date_time, update_date_time, question_body) VALUES (NOW(), NOW(), 'Вспомните времена, когда вы ещё учились в школе: какие предметы больше всего нравились?!');
INSERT INTO answer(creation_date_time, update_date_time, answer_body, correct_answer, question_id) VALUES (NOW(), NOW(), 'Труд — созданные в детстве вещи ваши родители хранят до сих пор.', 3, 1);
INSERT INTO answer(creation_date_time, update_date_time, answer_body, correct_answer, question_id) VALUES (NOW(), NOW(), 'Физкультура — вы активно участвовали во всех районных соревнованиях.', 1, 1);
INSERT INTO answer(creation_date_time, update_date_time, answer_body, correct_answer, question_id) VALUES (NOW(), NOW(), 'География и биология — именно на этих уроках вы начали узнавать об уникальных местах на планете и их обитателях.', 5, 1);
INSERT INTO answer(creation_date_time, update_date_time, answer_body, correct_answer, question_id) VALUES (NOW(), NOW(), 'Рисование, литература и мировая художественная культура.', 2, 1);
INSERT INTO answer(creation_date_time, update_date_time, answer_body, correct_answer, question_id) VALUES (NOW(), NOW(), 'Алгебра, геометрия, история и иностранные языки — вам всегда были интересны точные даты, цифры, грамматические правила', 4, 1);
