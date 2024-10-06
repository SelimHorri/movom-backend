INSERT INTO accomodations (uid, title, full_address, zipcode, country_dial_code, owner_name, number_of_rooms, description, actor_id, created_at, created_by, updated_at, updated_by) VALUES 
(gen_random_uuid(), 'Luxury Hotel', '123 Main St', '10001', '+1', 'Alice Johnson', 20, 'A five-star luxury hotel.', 1, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Budget Inn', '456 Elm St', '20002', '+44', 'Bob Smith', 10, 'A budget-friendly inn.', 2, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Beach Resort', '789 Ocean Dr', '30003', '+91', 'Charlie Brown', 15, 'A relaxing beach resort.', 3, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Mountain Cabin', '321 Hill Rd', '40004', '+49', 'Diana Prince', 5, 'A cozy cabin in the mountains.', 4, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'City Hostel', '654 Park Ave', '50005', '+81', 'Edward Elric', 50, 'A vibrant city hostel.', 5, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Family Lodge', '987 Pine St', '60006', '+33', 'Fiona Glenanne', 12, 'A family-friendly lodge.', 6, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Business Center', '741 Maple St', '70007', '+61', 'George Washington', 30, 'A center for business travelers.', 7, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Countryside Retreat', '852 Oak St', '80008', '+55', 'Hannah Montana', 8, 'A peaceful countryside retreat.', 8, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Heritage House', '963 Cedar St', '90009', '+39', 'Iris West', 6, 'A historic heritage house.', 9, now(), 'ADMIN', now(), 'ADMIN'),
(gen_random_uuid(), 'Eco Lodge', '159 Birch St', '10101', '+34', 'Jack Sparrow', 4, 'An eco-friendly lodge.', 10, now(), 'ADMIN', now(), 'ADMIN');