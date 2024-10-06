INSERT INTO amenity_reviewers (uid, rate, reviewed_at, reviewer_comment, amenity_id, reviewer_id, created_at, created_by, updated_at, updated_by) VALUES 
(gen_random_uuid(), 'PERFECT', now(), 'Excellent pool!', 1, 1, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'GOOD', now(), 'Good Wi-Fi.', 2, 2, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'PERFECT', now(), 'Great gym facilities.', 3, 3, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'NEUTRAL', now(), 'Spa could be better.', 4, 4, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'GOOD', now(), 'Convenient parking.', 5, 5, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'PERFECT', now(), 'Room service was prompt.', 6, 6, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'GOOD', now(), 'Restaurant food was delicious.', 7, 7, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'NEUTRAL', now(), 'Bar was crowded.', 8, 8, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'PERFECT', now(), 'Conference room was well equipped.', 9, 9, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'GOOD', now(), 'Shuttle service was on time.', 10, 10, now(), 'ADMIN', now(), 'ADMIN');