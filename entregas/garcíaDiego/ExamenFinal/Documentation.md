
# 1. Overview
The project aims to collect, manage, and analyze food intake data from patients over a span of five days. It allows for tracking different types of food consumed by the patients and performs various operations to manage and analyze the data.

# 2. Core Components
### 2.1. Main (Main.java)
Purpose: Serves as the entry point of the application. It initializes the necessary components and starts the application.
### 2.2. Management (Management.java)
Purpose: Handles the overall management of the survey, including operations like adding, removing, or updating patient data and their food intake records.
### 2.3. Survey (Survey.java)
Purpose: Represents the survey conducted, encapsulating the details of the food intake and the duration (5 days).
# 3. Data Structure Components
### 3.1. Tree (Tree.java) and TreeNode (TreeNode.java)
Purpose: These classes are used to implement a tree data structure, which is utilized for organizing the data (e.g., food items or patients) in a hierarchical manner.
### 3.2. TreeData (TreeData.java)
Purpose: Represents the data stored in each node of the tree, potentially containing information about the food items or patients.
### 3.3. GenericList (GenericList.java) and GenericNode (GenericNode.java)
Purpose: These classes provide a generic implementation of a linked list data structure, used for managing lists of entities like patients or food items.
# 4. Entity Components
### 4.1. Patient (Patient.java)
Purpose: Represents a patient, including their personal details and the records of food intake.
### 4.2. Food (Food.java)
Purpose: Represents a food item, containing details like name, type, and nutritional values.
### 4.3. Intake (Intake.java)
Purpose: Represents a single intake instance, detailing the patient, the food consumed, and the amount.
### 4.4. Day (Day.java)
Purpose: Represents a single day's record in the survey, containing multiple food intake instances.
### 4.5. Schedule (Schedule.java)
Purpose: Represents the schedule of the survey, detailing the intake for each day over the five-day period.
# 5. Functionality and Operations
Data Collection: The application is capable of collecting detailed food intake data from patients.
Data Management: It provides functionalities to add, remove, or update records of food intake and patient details.
Data Analysis: The application may offer analysis features, such as nutritional value assessment or intake patterns over the five days.
Data Structure Utilization: It uses tree and list data structures for efficient data management and retrieval.
