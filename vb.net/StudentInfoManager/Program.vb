Module Program
    Private newLine As String = $"{Environment.NewLine}"
    Sub Main(args As String())
        Menu()
        'InteractiveClearDemo()
        'Dim x1 As Integer = 10

        'UtilityMethods.WriteBox("HEllo test test")


    End Sub

    Sub Menu()
        Dim st As New StudentList
        st.AddingFakeStudents()
        st.AddingFakeStudents()

        Dim input As String
        Dim EXIT_MENU As Boolean = False
        Do

            UtilityMethods.WriteLineColor($" Student Info Manager{newLine}{newLine}", ConsoleColor.Blue)

            Console.WriteLine(" 1- Add Student")
            Console.WriteLine(" 2- Delete Student")
            Console.WriteLine(" 3- Edit Student Info")
            Console.WriteLine(" 4- Display Student Info")
            UtilityMethods.WriteLineColor(" 5- Exit", ConsoleColor.Red)
            Console.Write($"{newLine} Select an option: ")
            input = Console.ReadLine()

            Select Case input
                Case 1
                    st.AddStudent()
                    Console.Clear()
                Case 2
                    st.RemoveStudent()
                    Console.Clear()
                Case 3
                    st.EditStudent()
                    Console.Clear()
                Case 4
                    Dim y As Integer

                    Console.Clear()
                    UtilityMethods.WriteLineColor($"Student List{newLine}", ConsoleColor.Blue)
                    y = st.PrintStudentList()
                    Console.SetCursorPosition(2, y)
                    UtilityMethods.WriteLineColor("Press Enter to dismiss the list: ")
                    Console.ReadKey()
                    Console.Clear()
                Case 5
                    Console.WriteLine("Bye Bye!!!")
                    EXIT_MENU = True
                Case Else
                    Console.Clear()
                    UtilityMethods.WriteLineColor("Please select an available option", ConsoleColor.Red)
            End Select

        Loop Until EXIT_MENU

    End Sub










    Sub InteractiveClearDemo()
        Console.WriteLine("Interactive Line Clearing Demo:")

        While True
            Console.Write("Enter text (or 'exit' to quit): ")
            Dim input = Console.ReadLine()

            If input.ToLower() = "exit" Then
                Exit While
            End If

            ' Simulate some processing
            Console.Write("Processing")
            For i = 1 To 3
                System.Threading.Thread.Sleep(500)
                Console.Write(".")
            Next

            ' Clear processing line
            'ClearCurrentConsoleLine()

            ' Show result
            Console.WriteLine($"You entered: {input}")
        End While
    End Sub




End Module


'Functionality:
'
'Add a New Student:
'Provide an Option For the user To input information For a New student via the console. 
'Prompt the user For Each piece Of information required.

'Remove a Student:
'Allow the user To remove a student from the system. 
'This could involve selecting the student To remove based
'On their name Or another identifier entered via the console.

'Edit a Student:
'Enable the user To modify the information Of an existing student. 
'Prompt the user To input the identifier Of the student
'To be edited And Then provide options To update any Of the student's attributes.


'User Interface:
'
'Design a clear And intuitive console Interface
'that guides the user through the options For adding, 
'removing, And editing students.
'Utilize console output For displaying prompts And messages To the user.
'
'Implementation:
'
'Develop the program Using VB.NET console application.
'Utilize console input And output For interaction With the user.
'
'Testing:
'
'Thoroughly test the program To ensure it correctly Handles adding,
'removing, And editing student information.
'Verify the program's behavior for various scenarios,
'including valid and invalid user inputs.
'
'Additional Considerations:
'
'Implement robust Error handling To manage unexpected user inputs Or system errors gracefully.
'Consider adding features For data validation To ensure the integrity Of the student information.
'Provide options For displaying the list Of current students And their information To the user.


'Structure Program
'    Dim program_Id As Integer
'    Dim programName As String
'    Dim teacher As String
'    Dim MAX_STUDENT As Integer

'End Structure