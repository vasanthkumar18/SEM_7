#importing random module
import math
import random

class Environment: 
    def __init__ (self, e):
        self.loc = e
    def  __str__ (self):
        return "The environment is : [A:%s, B:%s]" % (("Dirty" if self.loc[0] == 1 else "Clean"),("Dirty" if self.loc[1] == 1 else "Clean"))


class bot:
    
    def __init__ (self, pos, environment):
        self.pos = pos
        self.score = 0
        self.environment = Environment(environment)
    
    def suck(self):
        print(self.pos," is clean now.")
        self.environment.loc[self.pos] = 0
        self.score += 1
   
    def run(self):
        
        print(self.environment)
        print("Start Position: ", self.pos)
        moves = 0
        state = []
        
        # Run for 1000 timesteps
        while moves < 1000:
            if self.environment.loc[self.pos]:
                self.environment.loc[self.pos] = 0
                self.score +=1
                state.append(self.pos)
            else:
                new = random.randint(0, 1)
                self.pos = new
                state.append(self.pos)
            moves += 1
        
        print("Performance Score: ", self.score)
        
        print("State space search graph: ")
        
        state_space_search_graph=str(state[0])
        
        for i in range(0,len(state)-1):
            state_space_search_graph+= " -> "+str(state[i]) 
        
        print(state_space_search_graph)


                
# Main         
def main():
    # looping through all cases
    start=0
    while start<2:
        A=0
        while A<2:
            B=0
            while B<2:
                Bot = bot(start, [A, B])
                Bot.run()
                print(" ")
                B+=1
            A+=1
        start+=1


if __name__ == '__main__':
    main()
if __name__ == '__main__':
    main()
