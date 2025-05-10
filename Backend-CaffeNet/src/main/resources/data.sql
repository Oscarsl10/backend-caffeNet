INSERT INTO admin (full_name, email, password, telefono)
VALUES
  ('Admin',
   'caffenet.service@gmail.com',
   'e633f4fc79badea1dc5db970cf397c8248bac47cc3acf9915ba60b5d76b0e88f',
   '31111111')
ON DUPLICATE KEY UPDATE
  full_name = VALUES(full_name),
  password  = VALUES(password),
  telefono  = VALUES(telefono);