Public Class StudentList
    Private ReadOnly StudentList As New List(Of Student)
    Private ReadOnly newLine As String = $"{Environment.NewLine}"
    Private ReadOnly TitleX As Integer = 35
    Private ReadOnly TitleY As Integer = 0


    Sub EditStudent()
        Dim title As String = "Editing Student"
        Dim student_Id As Integer = SelectStudentID(title)


        If student_Id = -1 Then
            Console.WriteLine("bye")
            Return
        End If



        Dim student As Student = StudentList.ElementAt(GetStudentIndexById(student_Id))

        Dim fistNameQu As String = $"Current first name '{student.FirstName}': "
        Dim lastNameQu As String = $"Current last name '{student.LastName}': "
        Dim ageQu As String = $"Current age '{student.Age}': "
        Dim programQu As String = $"Current program '{student.Program}': "
        Dim teacherNaQu As String = $"Current teacher '{student.Teacher}': "


        Dim fnSuccess As String = $"Successfully Changed first name to {student.FirstName}"
        Dim lnSuccess As String = $"Successfully Changed last name to {student.LastName}"
        Dim ageSuccess As String = $"Successfully Changed age to {student.Age}"
        Dim prSuccess As String = $"Successfully Changed program to {student.Program}"
        Dim teSuccess As String = $"Successfully Changed teacher to {student.Teacher}"

        Dim input As String
        Dim EXIT_MENU As Boolean = False


        Do

            Console.Clear()
            UtilityMethods.WriteAt(TitleX, TitleY, title, ConsoleColor.Blue)
            Console.WriteLine($"{newLine} Select a field to edit{newLine}")
            Console.WriteLine($" 1- First Name: {student.FirstName}")
            Console.WriteLine($" 2- Last Name: {student.LastName}")
            Console.WriteLine($" 3- Age: {student.Age}")
            Console.WriteLine($" 4- Program: {student.Program}")
            Console.WriteLine($" 5- Teacher: {student.Teacher}")
            Console.WriteLine(" 6- Exit")
            Console.Write(" Select an option: ")
            input = Console.ReadLine()

            Select Case input
                Case 1
                    EditPrompt(student.FirstName, fistNameQu, fnSuccess)
                Case 2
                    EditPrompt(student.LastName, lastNameQu, lnSuccess)
                Case 3
                    EditPrompt(student.Age, ageQu, ageSuccess)
                Case 4
                    EditPrompt(student.Program, programQu, prSuccess)
                Case 5
                    EditPrompt(student.Teacher, teacherNaQu, teSuccess)
                Case 6
                    Console.WriteLine("Bye Bye")
                    EXIT_MENU = True
                Case Else
                    Console.Clear()
                    Console.WriteLine("Please only enter one of the provided options")
            End Select

        Loop Until EXIT_MENU

    End Sub


    Sub AddStudent()

        Dim fistNameQu As String = "Enter the students first name: "
        Dim lastNameQu As String = "Enter the students last name: "
        Dim ageQu As String = "Enter the students age (16 - 100): "
        Dim programQu As String = "Enter the students program: "
        Dim teacherNaQu As String = "Enter the students teacher: "

        Console.Clear()
        UtilityMethods.WriteAt(TitleX, TitleY, "Adding New Student", ConsoleColor.Blue)
        UtilityMethods.WriteLineColor($"{newLine}press x to exit at any time{newLine}")


        Dim student As New Student(
            UtilityMethods.GetInputString(fistNameQu),
            UtilityMethods.GetInputString(lastNameQu),
            UtilityMethods.GetInputInt(ageQu),
            UtilityMethods.GetInputString(programQu),
            UtilityMethods.GetInputString(teacherNaQu))


        StudentList.Add(student)
    End Sub



    Sub RemoveStudent()
        Dim student_id As Integer
        Dim input As String
        Dim EXIT_MENU As Boolean = False

        Do
            Console.Clear()
            student_id = SelectStudentID($"Deleting{newLine}")
            If student_id = -1 Then
                EXIT_MENU = True
                Exit Do
            End If

            Console.Write($"  Would you like to remove student id {student_id} (y/n): ")
            input = Console.ReadLine()
            If input.Equals("x") Then
                EXIT_MENU = True
                Exit Do
            End If

            If input.Equals("y") Then
                StudentList.RemoveAt(GetStudentIndexById(student_id))
                Console.WriteLine("Successfully removed student with student ID: " + student_id.ToString)
                EXIT_MENU = True
            End If

        Loop Until EXIT_MENU

        Console.WriteLine("bye bye")



    End Sub


    ''' <summary>
    '''     Gets the index of the student in the student list returns their index
    ''' </summary>
    ''' <param name="student_ID"> Student Id Integer</param>
    ''' <returns>Returns -1 if student_ID does not exist</returns>
    Private Function GetStudentIndexById(student_ID As Integer) As Integer

        Dim indx As Integer = StudentList.FindIndex(Function(student As Student) student_ID = student.GetStudentID())

        Return indx

    End Function

    Private Function DoesStudentIdExist(studentId As Integer) As Boolean

        Dim indx As Integer = GetStudentIndexById(studentId)

        Return indx >= 0

    End Function


    Public Sub AddingFakeStudents()

        Dim student1 As New Student("warren", "lestum", 23, "Math", "nasirin")
        Dim student2 As New Student("adam", "qwfpqwf", 44, "Math", "nasirinqwfpqwfpqwfpq")
        Dim student3 As New Student("bob", "qwfpqwf", 45, "qwfpqwfpqwf", "nqwfpqwfpq")

        StudentList.Add(student1)
        StudentList.Add(student2)
        StudentList.Add(student3)


    End Sub


    ''' <summary>
    ''' 
    ''' </summary>
    ''' <param name="originalValue">this value need to point to the student field</param>
    ''' <param name="question"></param>
    ''' <param name="successMsg"></param>
    Private Sub EditPrompt(ByRef originalValue As String, question As String, successMsg As String)
        Console.Clear()
        Dim newValue As String
        newValue = UtilityMethods.GetInputString(question)

        If Not originalValue.Equals(newValue) AndAlso Not newValue.Equals("x") Then
            originalValue = newValue
            Console.WriteLine(successMsg)
            Return
        End If

        Console.WriteLine("Exited")
        Return

    End Sub


    ''' <summary>
    ''' Select and return the desired student Id
    ''' </summary>
    ''' <param name="message"></param>
    ''' <returns>Will return -1 when user wants to exit</returns>
    Private Function SelectStudentID(message As String) As Integer
        Dim input As String
        Dim _id As Integer
        Dim EXIT_MENU As Boolean = False
        Dim y As Integer



        Do
            Console.Clear()

            UtilityMethods.WriteAt(TitleX, TitleY, message, ConsoleColor.Blue)
            y = PrintStudentList()
            Console.SetCursorPosition(2, y)
            Console.Write("Select The student ID: ")
            input = Console.ReadLine()
            If input.Equals("x") Then
                Return -1
            End If

            Try
                _id = Integer.Parse(input)
            Catch ex As ArgumentException
                Console.Clear()
                Console.WriteLine("Please Input a number")

            Catch ex As FormatException
                Console.Clear()
                Console.WriteLine("Please Enter a valid number")
            Catch ex As OverflowException
                Console.Clear()
                Console.WriteLine("Please Enter a smaller number")
            End Try

            If DoesStudentIdExist(_id) Then
                EXIT_MENU = True
            Else
                Console.Clear()
                Console.WriteLine("Id does not exit")
            End If
        Loop Until EXIT_MENU

        Return _id
    End Function

    Function PrintStudentList() As Integer

        Dim horizontalSym As String = "-"
        Dim verticlSym As String = "|"
        Dim MAX_NUMBER_WIDTH As Integer = 4
        Dim MAX_NAME_WIDTH As Integer = 15
        Dim OFFSET_X As Integer = 5
        Dim OFFSET_Y As Integer = 3

        Dim ROW_COUNT As Integer = StudentList.Count
        Dim BOTTOM_ROW As Integer = ROW_COUNT + OFFSET_Y + 1
        Dim MAX_ROW_WIDTH As Integer = (4 * (MAX_NAME_WIDTH + 2)) + (2 * (MAX_NUMBER_WIDTH + 2))
        Dim LEFT_MOST_COL As Integer = OFFSET_X - 2
        Dim RIGHT_MOST_COL As Integer = MAX_ROW_WIDTH + 2

        Dim idX As Integer = OFFSET_X
        Dim fnX As Integer = idX + (MAX_NUMBER_WIDTH + 2)
        Dim lnX As Integer = fnX + (MAX_NAME_WIDTH + 2)
        Dim ageX As Integer = lnX + (MAX_NAME_WIDTH + 2)
        Dim prX As Integer = ageX + (MAX_NUMBER_WIDTH + 2)
        Dim trX As Integer = prX + (MAX_NAME_WIDTH + 1)


        ' x value for each item won't change
        ' I add 2 for both the info and separator row
        Dim current_Row As Integer = OFFSET_Y + 2

        UtilityMethods.WriteAt(idX, current_Row - 2, "Id")

        UtilityMethods.WriteAt(fnX, current_Row - 2, "First Name")

        UtilityMethods.WriteAt(lnX, current_Row - 2, "Last Name")

        UtilityMethods.WriteAt(ageX, current_Row - 2, "Age")

        UtilityMethods.WriteAt(prX, current_Row - 2, "Program")

        UtilityMethods.WriteAt(trX, current_Row - 2, "Teacher")

        For counter As Integer = OFFSET_X To RIGHT_MOST_COL - 2
            UtilityMethods.WriteAt(counter, current_Row - 1, horizontalSym, ConsoleColor.Blue)
        Next


        For Each student As Student In StudentList

            UtilityMethods.WriteAt(idX, current_Row, UtilityMethods.TrimString(MAX_NUMBER_WIDTH, student.GetStudentID.ToString))

            UtilityMethods.WriteAt(fnX, current_Row, UtilityMethods.TrimString(MAX_NAME_WIDTH, student.FirstName))

            UtilityMethods.WriteAt(lnX, current_Row, UtilityMethods.TrimString(MAX_NAME_WIDTH, student.LastName))

            UtilityMethods.WriteAt(ageX, current_Row, UtilityMethods.TrimString(MAX_NUMBER_WIDTH, student.Age))

            UtilityMethods.WriteAt(prX, current_Row, UtilityMethods.TrimString(MAX_NAME_WIDTH, student.Program))

            UtilityMethods.WriteAt(trX, current_Row, UtilityMethods.TrimString(MAX_NAME_WIDTH, student.Teacher))

            current_Row += 1
        Next

        'Horizontal
        For counter As Integer = LEFT_MOST_COL To RIGHT_MOST_COL
            UtilityMethods.WriteAt(counter, OFFSET_Y - 1, horizontalSym, ConsoleColor.Yellow)
            UtilityMethods.WriteAt(counter, BOTTOM_ROW + 1, horizontalSym, ConsoleColor.Yellow)
        Next

        'Vertical
        For counter As Integer = OFFSET_Y To BOTTOM_ROW
            UtilityMethods.WriteAt(LEFT_MOST_COL, counter, verticlSym, ConsoleColor.Yellow)
            UtilityMethods.WriteAt(RIGHT_MOST_COL, counter, verticlSym, ConsoleColor.Yellow)
        Next

        Return BOTTOM_ROW + 5

    End Function






End Class
