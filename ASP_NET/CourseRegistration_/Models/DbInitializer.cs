namespace CourseRegistration_.Models
{
    public class DbInitializer
    {
        public static void Initialize(CourseRegContext context)
        {
            if (context.Course.Any())
            {
                return;
            }
            // Course Objects
            var courses = new Course[]
            {
                new Course
                {
                    CourseId = 1,
                    CourseNumber = "CHEM1050",
                    CourseName = "Chemistry",
                    Description = "Fundamental principles of chemical science"
                },
                new Course
                {
                    CourseId = 2,
                    CourseNumber = "ECON4022",
                    CourseName = "Microeconomics",
                    Description = "Introduction to microeconomic theories and principles"
                },
                new Course
                {
                    CourseId = 3,
                    CourseNumber = "ECON4041",
                    CourseName = "Macroeconomics",
                    Description = "Comprehensive study of macroeconomic systems"
                },
                new Course
                {
                    CourseId = 4,
                    CourseNumber = "MATH1045",
                    CourseName = "Calculus",
                    Description = "Advanced mathematical analysis and calculus concepts"
                },
                new Course
                {
                    CourseId = 5,
                    CourseNumber = "MATH3141",
                    CourseName = "Trigonometry",
                    Description = "In-depth study of trigonometric functions and applications"
                },
                new Course
                {
                    CourseId = 6,
                    CourseNumber = "ENG2021",
                    CourseName = "Composition",
                    Description = "Academic and creative writing techniques"
                },
                new Course
                {
                    CourseId = 7,
                    CourseNumber = "ENG2042",
                    CourseName = "Literature",
                    Description = "Exploration of literary works and critical analysis"
                },
                new Course
                {
                    CourseId = 8,
                    CourseNumber = "PHYS2100",
                    CourseName = "Physics",
                    Description = "Fundamental principles of physical sciences"
                },
                new Course
                {
                    CourseId = 9,
                    CourseNumber = "CS1100",
                    CourseName = "Introduction to Programming",
                    Description = "Basic programming concepts and algorithms"
                },
                new Course
                {
                    CourseId = 10,
                    CourseNumber = "HIST3050",
                    CourseName = "World History",
                    Description = "Comprehensive global historical perspectives"
                }
            };

            context.Course.AddRange(courses);
            context.SaveChanges();

            // Student Objects
            var students = new Student[]
            {
                new Student
                {
                    FirstName = "Carson",
                    LastName = "Alexander",
                    Email = "carson.alexander@university.edu",
                    PhoneNumber = "555-001-0001"
                },
                new Student
                {
                    FirstName = "Meredith",
                    LastName = "Alonso",
                    Email = "meredith.alonso@university.edu",
                    PhoneNumber = "555-001-0002"
                },
                new Student
                {
                    FirstName = "Arturo",
                    LastName = "Anand",
                    Email = "arturo.anand@university.edu",
                    PhoneNumber = "555-001-0003"
                },
                new Student
                {
                    FirstName = "Gytis",
                    LastName = "Barzdukas",
                    Email = "gytis.barzdukas@university.edu",
                    PhoneNumber = "555-001-0004"
                },
                new Student
                {
                    FirstName = "Yan",
                    LastName = "Li",
                    Email = "yan.li@university.edu",
                    PhoneNumber = "555-001-0005"
                },
                new Student
                {
                    FirstName = "Peggy",
                    LastName = "Justice",
                    Email = "peggy.justice@university.edu",
                    PhoneNumber = "555-001-0006"
                },
                new Student
                {
                    FirstName = "Laura",
                    LastName = "Norman",
                    Email = "laura.norman@university.edu",
                    PhoneNumber = "555-001-0007"
                },
                new Student
                {
                    FirstName = "Nino",
                    LastName = "Olivetto",
                    Email = "nino.olivetto@university.edu",
                    PhoneNumber = "555-001-0008"
                },
                new Student
                {
                    FirstName = "Sophia",
                    LastName = "Rodriguez",
                    Email = "sophia.rodriguez@university.edu",
                    PhoneNumber = "555-001-0009"
                },
                new Student
                {
                    FirstName = "Alexander",
                    LastName = "Kim",
                    Email = "alexander.kim@university.edu",
                    PhoneNumber = "555-001-0010"
                }
            };

            context.Student.AddRange(students);
            context.SaveChanges();


            // Instructor Objects
            var instructors = new Instructor[]
            {
                new Instructor
                {
                    FirstName = "David",
                    LastName = "Williams",
                    Email = "david.williams@university.edu",
                    CourseId = 1
                },
                new Instructor
                {
                    FirstName = "Rachel",
                    LastName = "Garcia",
                    Email = "rachel.garcia@university.edu",
                    CourseId = 2
                },
                new Instructor
                {
                    FirstName = "Jonathan",
                    LastName = "Lee",
                    Email = "jonathan.lee@university.edu",
                    CourseId = 3
                },
                new Instructor
                {
                    FirstName = "Maria",
                    LastName = "Petrova",
                    Email = "maria.petrova@university.edu",
                    CourseId = 4
                },
                new Instructor
                {
                    FirstName = "Thomas",
                    LastName = "Anderson",
                    Email = "thomas.anderson@university.edu",
                    CourseId = 5
                },
                new Instructor
                {
                    FirstName = "Emily",
                    LastName = "Johnson",
                    Email = "emily.johnson@university.edu",
                    CourseId = 6
                },
                new Instructor
                {
                    FirstName = "Michael",
                    LastName = "Chen",
                    Email = "michael.chen@university.edu",
                    CourseId = 7
                },
                new Instructor
                {
                    FirstName = "Sarah",
                    LastName = "Brown",
                    Email = "sarah.brown@university.edu",
                    CourseId = 8
                },
                new Instructor
                {
                    FirstName = "Daniel",
                    LastName = "Miller",
                    Email = "daniel.miller@university.edu",
                    CourseId = 9
                },
                new Instructor
                {
                    FirstName = "Elizabeth",
                    LastName = "Taylor",
                    Email = "elizabeth.taylor@university.edu",
                    CourseId = 10
                }
            };

            context.Instructor.AddRange(instructors);
            context.SaveChanges();
        }
    }
}
