-- Identity: System Admin and Tech User
INSERT INTO users (name, role, email, phone, password_hash, mfa_enabled, status, created_at, updated_at) 
VALUES ('Sys Admin', 'Admin', 'admin@autoconnect.com', '555-0100', 'hashed_pass_1', false, 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (name, role, email, phone, password_hash, mfa_enabled, status, created_at, updated_at) 
VALUES ('Bob Technician', 'Technician', 'bob.tech@autoconnect.com', '555-0101', 'hashed_pass_2', false, 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (name, role, email, phone, password_hash, mfa_enabled, status, created_at, updated_at) 
VALUES ('Alice Customer', 'Customer', 'alice@customer.com', '555-0200', 'hashed_pass_3', false, 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- CRM: Customer Profile
INSERT INTO customer (user_id, name, contact_info_json, preferred_dealer_id, vehicle_ownership_json, loyalty_tier, status, created_at)
VALUES (3, 'Alice Customer', '{"phone":"555-0200", "address":"123 Main St"}', 1, '{"vehicles":[1]}', 'Gold', 'ACTIVE', CURRENT_TIMESTAMP);

-- Inventory: Vehicles
INSERT INTO vehicle (vin, stock_number, make, model, model_year, trim, color, mileage, vehicle_condition, location_id, status, base_price, msrp, created_at)
VALUES ('1HGCM82633A004', 'STK-2023-01', 'Honda', 'Accord', 2023, 'EX-L', 'Crystal Black', 12000, 'Used', 1, 'AVAILABLE', 23000.00, 25000.00, CURRENT_TIMESTAMP);

INSERT INTO vehicle (vin, stock_number, make, model, model_year, trim, color, mileage, vehicle_condition, location_id, status, base_price, msrp, created_at)
VALUES ('JTMEB3FV123456', 'STK-2024-05', 'Toyota', 'RAV4', 2024, 'XLE Premium', 'Lunar Rock', 15, 'New', 1, 'AVAILABLE', 31000.00, 33500.00, CURRENT_TIMESTAMP);

-- Parts Catalog: Parts
INSERT INTO part (part_number, description, manufacturer, unit_of_measure, cost, retail_price, status)
VALUES ('BRK-PAD-01', 'Ceramic Brake Pads Front', 'AutoPartsInc', 'SET', 25.50, 65.00, 'ACTIVE');

INSERT INTO part (part_number, description, manufacturer, unit_of_measure, cost, retail_price, status)
VALUES ('OIL-FIL-02', 'Synthetic Oil Filter', 'FilterTech', 'EACH', 4.20, 12.99, 'ACTIVE');

-- Service: Job Card (Assuming WOID 1 exists, assigning to Bob Technician)
INSERT INTO job_card (woid, technician_id, start_at, end_at, findings_json, actions_json, photos_uri_json, signed_off_by_fk, signed_off_at, status)
VALUES (1, 2, CURRENT_TIMESTAMP, null, '{"issue":"Brake pads worn"}', '{"action":"Replacing front pads"}', '[]', null, null, 'IN_PROGRESS');

-- Financial: Invoice
INSERT INTO invoice (customer_id, related_entity_id, line_items_json, subtotal, taxes, discounts_json, total_amount, issued_at, due_date, status, invoice_uri)
VALUES (1, 1, '[{"item":"Brake Replacement", "cost": 65.00}]', 65.00, 5.20, '[]', 70.20, CURRENT_TIMESTAMP, CURRENT_DATE, 'UNPAID', 'http://internal.autoconnect/invoices/1');
