// Mock data for testing frontend without backend
export const mockStudents = [
  {
    id: 1,
    name: "Alice Johnson",
    email: "alice.johnson@university.edu",
    major: "Computer Science",
    year: 3,
    joinedDate: "2023-01-15",
    courses: ["CPSC 2150", "CPSC 1010", "MATH 2060", "STAT 2300"],
    availabilities: [
      { dayOfWeek: "Monday", timeSlot: "7PM-8PM" },
      { dayOfWeek: "Wednesday", timeSlot: "2PM-4PM" },
      { dayOfWeek: "Friday", timeSlot: "10AM-12PM" }
    ],
    availabilitySlots: ["Monday 19:00-20:00", "Wednesday 14:00-16:00", "Friday 10:00-12:00"],
    studySessions: 8,
    rating: 4.8,
    bio: "Third-year CS student passionate about algorithms and web development. Love collaborative learning!",
    skills: ["Python", "JavaScript", "Data Structures", "Web Development"],
    profilePicture: "👩‍💻"
  },
  {
    id: 2,
    name: "Bob Smith",
    email: "bob.smith@university.edu", 
    major: "Mathematics",
    year: 2,
    joinedDate: "2023-02-20",
    courses: ["MATH 2080", "STAT 2300", "CPSC 1010", "PHYS 1010"],
    availabilities: [
      { dayOfWeek: "Tuesday", timeSlot: "6PM-7PM" },
      { dayOfWeek: "Thursday", timeSlot: "3PM-5PM" },
      { dayOfWeek: "Saturday", timeSlot: "9AM-11AM" }
    ],
    availabilitySlots: ["Tuesday 18:00-19:00", "Thursday 15:00-17:00", "Saturday 09:00-11:00"],
    studySessions: 5,
    rating: 4.6,
    bio: "Math major with a love for problem-solving. Always happy to help with calculus and statistics!",
    skills: ["Calculus", "Statistics", "Linear Algebra", "Mathematical Modeling"],
    profilePicture: "🧮"
  },
  {
    id: 3,
    name: "Charlie Brown",
    email: "charlie.brown@university.edu",
    major: "Physics", 
    year: 4,
    joinedDate: "2023-01-08",
    courses: ["PHYS 1010", "MATH 1060", "PHYS 2020", "MATH 2080"],
    availabilities: [
      { dayOfWeek: "Monday", timeSlot: "7PM-8PM" },
      { dayOfWeek: "Friday", timeSlot: "1PM-3PM" },
      { dayOfWeek: "Sunday", timeSlot: "2PM-4PM" }
    ],
    availabilitySlots: ["Monday 19:00-20:00", "Friday 13:00-15:00", "Sunday 14:00-16:00"],
    studySessions: 12,
    rating: 4.9,
    bio: "Senior physics student specializing in quantum mechanics. Love explaining complex concepts!",
    skills: ["Quantum Physics", "Thermodynamics", "Mathematical Physics", "Lab Techniques"],
    profilePicture: "⚛️"
  },
  {
    id: 4,
    name: "Diana Prince",
    email: "diana.prince@university.edu",
    major: "Engineering",
    year: 1,
    joinedDate: "2023-03-10",
    courses: ["ENG 1000", "MATH 1060", "PHYS 1010", "CHEM 1010"],
    availabilities: [
      { dayOfWeek: "Monday", timeSlot: "4PM-6PM" },
      { dayOfWeek: "Wednesday", timeSlot: "11AM-1PM" },
      { dayOfWeek: "Friday", timeSlot: "2PM-4PM" }
    ],
    availabilitySlots: ["Monday 16:00-18:00", "Wednesday 11:00-13:00", "Friday 14:00-16:00"],
    studySessions: 3,
    rating: 4.4,
    bio: "First-year engineering student eager to learn and collaborate. Strong in math and science!",
    skills: ["Engineering Design", "CAD", "Mathematics", "Problem Solving"],
    profilePicture: "⚙️"
  },
  {
    id: 5,
    name: "Emma Brown",
    email: "emma.brown@university.edu",
    major: "Biology",
    year: 3,
    joinedDate: "2023-01-25",
    courses: ["BIO 2010", "BIO 2020", "CHEM 2010", "STAT 2300"],
    availabilities: [
      { dayOfWeek: "Tuesday", timeSlot: "10AM-12PM" },
      { dayOfWeek: "Thursday", timeSlot: "1PM-3PM" },
      { dayOfWeek: "Saturday", timeSlot: "10AM-12PM" }
    ],
    availabilitySlots: ["Tuesday 10:00-12:00", "Thursday 13:00-15:00", "Saturday 10:00-12:00"],
    studySessions: 7,
    rating: 4.7,
    bio: "Biology major passionate about molecular biology and research. Always ready to study together!",
    skills: ["Molecular Biology", "Genetics", "Lab Research", "Data Analysis"],
    profilePicture: "🧬"
  },
  {
    id: 6,
    name: "Frank Wilson",
    email: "frank.wilson@university.edu",
    major: "Chemistry",
    year: 2,
    joinedDate: "2023-02-15",
    courses: ["CHEM 2010", "CHEM 2020", "MATH 2060", "PHYS 1010"],
    availabilities: [
      { dayOfWeek: "Monday", timeSlot: "3PM-5PM" },
      { dayOfWeek: "Wednesday", timeSlot: "7PM-9PM" },
      { dayOfWeek: "Friday", timeSlot: "11AM-1PM" }
    ],
    availabilitySlots: ["Monday 15:00-17:00", "Wednesday 19:00-21:00", "Friday 11:00-13:00"],
    studySessions: 6,
    rating: 4.5,
    bio: "Chemistry student with a focus on organic chemistry. Love lab work and chemical reactions!",
    skills: ["Organic Chemistry", "Analytical Chemistry", "Lab Techniques", "Chemical Analysis"],
    profilePicture: "🧪"
  },
  {
    id: 7,
    name: "Grace Lee",
    email: "grace.lee@university.edu",
    major: "Economics",
    year: 4,
    joinedDate: "2022-12-10",
    courses: ["ECON 3010", "ECON 3020", "STAT 2300", "MATH 2080"],
    availabilities: [
      { dayOfWeek: "Tuesday", timeSlot: "2PM-4PM" },
      { dayOfWeek: "Thursday", timeSlot: "6PM-8PM" },
      { dayOfWeek: "Sunday", timeSlot: "1PM-3PM" }
    ],
    availabilitySlots: ["Tuesday 14:00-16:00", "Thursday 18:00-20:00", "Sunday 13:00-15:00"],
    studySessions: 10,
    rating: 4.8,
    bio: "Senior economics student specializing in econometrics. Great with data analysis and theory!",
    skills: ["Econometrics", "Data Analysis", "Economic Theory", "Financial Modeling"],
    profilePicture: "📊"
  },
  {
    id: 8,
    name: "Henry Kim",
    email: "henry.kim@university.edu",
    major: "Computer Science",
    year: 1,
    joinedDate: "2023-03-05",
    courses: ["CPSC 1010", "MATH 1060", "ENG 1000", "STAT 1000"],
    availabilities: [
      { dayOfWeek: "Monday", timeSlot: "5PM-7PM" },
      { dayOfWeek: "Wednesday", timeSlot: "3PM-5PM" },
      { dayOfWeek: "Saturday", timeSlot: "2PM-4PM" }
    ],
    availabilitySlots: ["Monday 17:00-19:00", "Wednesday 15:00-17:00", "Saturday 14:00-16:00"],
    studySessions: 2,
    rating: 4.3,
    bio: "First-year CS student excited about programming. Looking forward to learning with others!",
    skills: ["Python Basics", "Problem Solving", "Mathematics", "Logical Thinking"],
    profilePicture: "💻"
  },
  {
    id: 9,
    name: "Isabella Garcia",
    email: "isabella.garcia@university.edu",
    major: "Psychology",
    year: 3,
    joinedDate: "2023-01-30",
    courses: ["PSYC 2010", "PSYC 2020", "STAT 2300", "BIO 1010"],
    availabilities: [
      { dayOfWeek: "Tuesday", timeSlot: "11AM-1PM" },
      { dayOfWeek: "Thursday", timeSlot: "4PM-6PM" },
      { dayOfWeek: "Friday", timeSlot: "9AM-11AM" }
    ],
    availabilitySlots: ["Tuesday 11:00-13:00", "Thursday 16:00-18:00", "Friday 09:00-11:00"],
    studySessions: 9,
    rating: 4.7,
    bio: "Psychology major interested in cognitive science. Great at research methods and statistics!",
    skills: ["Research Methods", "Statistical Analysis", "Cognitive Psychology", "Data Interpretation"],
    profilePicture: "🧠"
  },
  {
    id: 10,
    name: "Jack Thompson",
    email: "jack.thompson@university.edu",
    major: "Business Administration",
    year: 2,
    joinedDate: "2023-02-28",
    courses: ["BUS 2010", "ECON 1010", "MATH 1060", "STAT 1000"],
    availabilities: [
      { dayOfWeek: "Monday", timeSlot: "6PM-8PM" },
      { dayOfWeek: "Wednesday", timeSlot: "12PM-2PM" },
      { dayOfWeek: "Sunday", timeSlot: "3PM-5PM" }
    ],
    availabilitySlots: ["Monday 18:00-20:00", "Wednesday 12:00-14:00", "Sunday 15:00-17:00"],
    studySessions: 4,
    rating: 4.4,
    bio: "Business student focused on management and finance. Good with presentations and group work!",
    skills: ["Business Strategy", "Financial Analysis", "Marketing", "Team Leadership"],
    profilePicture: "💼"
  },
  {
    id: 11,
    name: "Kate Anderson",
    email: "kate.anderson@university.edu",
    major: "English Literature",
    year: 4,
    joinedDate: "2022-11-15",
    courses: ["ENG 3010", "ENG 3020", "HIST 2010", "PHIL 2010"],
    availabilities: [
      { dayOfWeek: "Tuesday", timeSlot: "1PM-3PM" },
      { dayOfWeek: "Thursday", timeSlot: "10AM-12PM" },
      { dayOfWeek: "Saturday", timeSlot: "11AM-1PM" }
    ],
    availabilitySlots: ["Tuesday 13:00-15:00", "Thursday 10:00-12:00", "Saturday 11:00-13:00"],
    studySessions: 11,
    rating: 4.9,
    bio: "Senior English Lit student with expertise in critical analysis. Love discussing literature!",
    skills: ["Literary Analysis", "Critical Writing", "Research", "Academic Writing"],
    profilePicture: "📚"
  },
  {
    id: 12,
    name: "Liam Davis",
    email: "liam.davis@university.edu",
    major: "Mechanical Engineering",
    year: 3,
    joinedDate: "2023-01-12",
    courses: ["MECH 2010", "MECH 2020", "MATH 2080", "PHYS 2010"],
    availabilities: [
      { dayOfWeek: "Monday", timeSlot: "2PM-4PM" },
      { dayOfWeek: "Wednesday", timeSlot: "5PM-7PM" },
      { dayOfWeek: "Friday", timeSlot: "3PM-5PM" }
    ],
    availabilitySlots: ["Monday 14:00-16:00", "Wednesday 17:00-19:00", "Friday 15:00-17:00"],
    studySessions: 6,
    rating: 4.6,
    bio: "Mechanical engineering student passionate about design and innovation. Great with CAD!",
    skills: ["CAD Design", "Mechanical Systems", "3D Modeling", "Engineering Analysis"],
    profilePicture: "🔧"
  }
];

export const mockSessions = [
  {
    id: 1,
    course: "CPSC 2150",
    title: "Data Structures & Algorithms Study Group",
    description: "Working through binary trees, sorting algorithms, and complexity analysis",
    time: "Monday 7PM-8PM",
    date: "2024-10-21",
    location: "Library Room 204",
    maxParticipants: 5,
    creator: { id: 1, name: "Alice Johnson" },
    participants: [
      { id: 1, name: "Alice Johnson" },
      { id: 3, name: "Charlie Brown" },
      { id: 8, name: "Henry Kim" }
    ],
    status: "active",
    subject: "Computer Science",
    difficulty: "intermediate",
    tags: ["algorithms", "data-structures", "coding"]
  },
  {
    id: 2,
    course: "MATH 2080", 
    title: "Calculus II Problem Solving",
    description: "Integration techniques, series, and differential equations practice",
    time: "Tuesday 6PM-7PM",
    date: "2024-10-22",
    location: "Math Building Room 105",
    maxParticipants: 4,
    creator: { id: 2, name: "Bob Smith" },
    participants: [
      { id: 2, name: "Bob Smith" },
      { id: 7, name: "Grace Lee" },
      { id: 12, name: "Liam Davis" }
    ],
    status: "active",
    subject: "Mathematics",
    difficulty: "advanced",
    tags: ["calculus", "integration", "differential-equations"]
  },
  {
    id: 3,
    course: "PHYS 1010",
    title: "Physics Fundamentals Review",
    description: "Mechanics, waves, and thermodynamics concepts and problem solving",
    time: "Wednesday 2PM-4PM",
    date: "2024-10-23",
    location: "Physics Lab 301",
    maxParticipants: 6,
    creator: { id: 3, name: "Charlie Brown" },
    participants: [
      { id: 3, name: "Charlie Brown" },
      { id: 4, name: "Diana Prince" },
      { id: 6, name: "Frank Wilson" }
    ],
    status: "active",
    subject: "Physics",
    difficulty: "beginner",
    tags: ["mechanics", "waves", "thermodynamics"]
  },
  {
    id: 4,
    course: "BIO 2010",
    title: "Molecular Biology Study Session",
    description: "DNA replication, transcription, translation, and protein synthesis",
    time: "Thursday 1PM-3PM",
    date: "2024-10-24",
    location: "Biology Building Room 205",
    maxParticipants: 5,
    creator: { id: 5, name: "Emma Brown" },
    participants: [
      { id: 5, name: "Emma Brown" },
      { id: 9, name: "Isabella Garcia" }
    ],
    status: "active",
    subject: "Biology",
    difficulty: "intermediate",
    tags: ["molecular-biology", "dna", "proteins"]
  },
  {
    id: 5,
    course: "CHEM 2010",
    title: "Organic Chemistry Mechanisms",
    description: "Reaction mechanisms, stereochemistry, and synthesis problems",
    time: "Friday 11AM-1PM",
    date: "2024-10-25",
    location: "Chemistry Lab 102",
    maxParticipants: 4,
    creator: { id: 6, name: "Frank Wilson" },
    participants: [
      { id: 6, name: "Frank Wilson" },
      { id: 5, name: "Emma Brown" }
    ],
    status: "active",
    subject: "Chemistry",
    difficulty: "advanced",
    tags: ["organic-chemistry", "mechanisms", "synthesis"]
  },
  {
    id: 6,
    course: "STAT 2300",
    title: "Statistics and Probability Workshop",
    description: "Hypothesis testing, confidence intervals, and probability distributions",
    time: "Saturday 10AM-12PM",
    date: "2024-10-26",
    location: "Statistics Lab 150",
    maxParticipants: 6,
    creator: { id: 7, name: "Grace Lee" },
    participants: [
      { id: 7, name: "Grace Lee" },
      { id: 1, name: "Alice Johnson" },
      { id: 2, name: "Bob Smith" },
      { id: 5, name: "Emma Brown" },
      { id: 9, name: "Isabella Garcia" }
    ],
    status: "active",
    subject: "Statistics",
    difficulty: "intermediate",
    tags: ["statistics", "probability", "hypothesis-testing"]
  },
  {
    id: 7,
    course: "CPSC 1010",
    title: "Programming Fundamentals Help",
    description: "Python basics, loops, functions, and debugging practice",
    time: "Monday 5PM-7PM",
    date: "2024-10-21",
    location: "Computer Lab 115",
    maxParticipants: 8,
    creator: { id: 1, name: "Alice Johnson" },
    participants: [
      { id: 1, name: "Alice Johnson" },
      { id: 8, name: "Henry Kim" },
      { id: 2, name: "Bob Smith" },
      { id: 4, name: "Diana Prince" }
    ],
    status: "active",
    subject: "Computer Science",
    difficulty: "beginner",
    tags: ["python", "programming", "fundamentals"]
  },
  {
    id: 8,
    course: "ECON 3010",
    title: "Microeconomics Theory Discussion",
    description: "Market structures, game theory, and economic modeling",
    time: "Tuesday 2PM-4PM",
    date: "2024-10-22",
    location: "Economics Building Room 220",
    maxParticipants: 5,
    creator: { id: 7, name: "Grace Lee" },
    participants: [
      { id: 7, name: "Grace Lee" },
      { id: 10, name: "Jack Thompson" }
    ],
    status: "active",
    subject: "Economics",
    difficulty: "advanced",
    tags: ["microeconomics", "game-theory", "modeling"]
  },
  {
    id: 9,
    course: "ENG 3010",
    title: "Literature Analysis Workshop",
    description: "Critical analysis techniques for modern and classical literature",
    time: "Thursday 10AM-12PM",
    date: "2024-10-24",
    location: "English Department Seminar Room",
    maxParticipants: 6,
    creator: { id: 11, name: "Kate Anderson" },
    participants: [
      { id: 11, name: "Kate Anderson" }
    ],
    status: "open",
    subject: "English Literature",
    difficulty: "advanced",
    tags: ["literature", "analysis", "critical-thinking"]
  },
  {
    id: 10,
    course: "MECH 2010",
    title: "Engineering Design Project Help",
    description: "CAD modeling, design principles, and project collaboration",
    time: "Wednesday 5PM-7PM",
    date: "2024-10-23",
    location: "Engineering Workshop 301",
    maxParticipants: 4,
    creator: { id: 12, name: "Liam Davis" },
    participants: [
      { id: 12, name: "Liam Davis" },
      { id: 4, name: "Diana Prince" }
    ],
    status: "active",
    subject: "Engineering",
    difficulty: "intermediate",
    tags: ["cad", "design", "engineering"]
  },
  {
    id: 11,
    course: "PSYC 2010",
    title: "Research Methods Study Group",
    description: "Experimental design, data collection, and statistical analysis in psychology",
    time: "Friday 9AM-11AM",
    date: "2024-10-25",
    location: "Psychology Building Room 180",
    maxParticipants: 5,
    creator: { id: 9, name: "Isabella Garcia" },
    participants: [
      { id: 9, name: "Isabella Garcia" }
    ],
    status: "open",
    subject: "Psychology",
    difficulty: "intermediate",
    tags: ["research-methods", "statistics", "experimental-design"]
  },
  {
    id: 12,
    course: "BUS 2010",
    title: "Business Strategy Case Studies",
    description: "Analyzing real business cases and strategic decision making",
    time: "Sunday 3PM-5PM",
    date: "2024-10-27",
    location: "Business Building Conference Room",
    maxParticipants: 6,
    creator: { id: 10, name: "Jack Thompson" },
    participants: [
      { id: 10, name: "Jack Thompson" }
    ],
    status: "open",
    subject: "Business",
    difficulty: "intermediate",
    tags: ["strategy", "case-studies", "business-analysis"]
  }
];