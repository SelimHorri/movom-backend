INSERT INTO amenities (uid, name, description, accomodation_id, created_at, created_by, updated_at, updated_by) VALUES 
(gen_random_uuid(), 'Swimming Pool', 'A large swimming pool.', 1, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Free Wi-Fi', 'Complimentary high-speed internet.', 2, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Gym', 'Fully equipped gym.', 3, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Spa', 'Relaxing spa services.', 4, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Parking', 'Free parking space available.', 5, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Room Service', '24/7 room service.', 6, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Restaurant', 'On-site restaurant.', 7, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Bar', 'A cozy bar with various drinks.', 8, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Conference Room', 'For business meetings.', 9, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Airport Shuttle', 'Free shuttle service to the airport.', 10, now(), 'ADMIN', now(), 'ADMIN');